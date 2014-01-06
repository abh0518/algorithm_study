#!/usr/bin/bash ruby

class MemorizePi

  attr_accessor :numbers, :cache, :size

  def initialize numbers
    @numbers = numbers
    @cache = []
  end

  def start
    find(0)
  end

  def find startpoint
    return 0 if !(startpoint < @numbers.size)
    return @cache[startpoint] if !@cache[startpoint].nil?

    result = 987654321
    (2..4).each do |index|
      endpoint = startpoint + index
      if endpoint < @numbers.size
        score = score?(startpoint, endpoint) + find(endpoint+1)
        result = [ score , result].min
      end
    end

    @cache[startpoint] = result
    return result
  end

  def score? startpoint, endpoint
    if self.repeat? startpoint, endpoint
      return 1
    elsif self.monotone? startpoint, endpoint
      return 2
    elsif self.rotation? startpoint, endpoint
      return 4
    elsif self.progression? startpoint, endpoint
      return 5
    end
    return 10
  end

  # 하나의 숫자가 반복되는 경우 찾기
  def repeat? startpoint, endpoint
    base = @numbers[startpoint]
    (startpoint..endpoint).each do |index|
      if @numbers[index] != base then
        return false
      end
    end
    return true
  end

  # 1씩 단조 증가/감소 경우 찾기
  def monotone? startpoint, endpoint
    n = @numbers[startpoint+1] - @numbers[startpoint]
    return false if n != 1 && n != -1
    n_before = @numbers[startpoint] - n
    (startpoint..endpoint).each do |index|
      if @numbers[index] != n_before + n then
        return false
      end
      n_before = @numbers[index]

    end
    return true
  end

  # 2개의 숫자가 번갈아가며 나타나는 경우 찾기
  def rotation? startpoint, endpoint
    n_first = @numbers[startpoint]
    n_second = @numbers[startpoint+1]
    index = 0
    (startpoint..endpoint).each do |index|
      r_section = index%2
      if r_section == 0 && @numbers[index] != n_first
        return false
      elsif r_section == 1 && @numbers[index] != n_second then
        return false
      end
    end
    return true
  end

  # 등차수열인 경우 찾기
  def progression? startpoint, endpoint
    n = @numbers[startpoint+1] - @numbers[startpoint]
    return false if n == 0
    n_before = @numbers[startpoint] - n
    (startpoint..endpoint).each do |index|
      if @numbers[index] != n_before + n then
        return false
      end
      n_before = @numbers[index]
    end
    return true
  end

end


if __FILE__ == $0 then

  results = []
  c = gets
  c.to_i.times do
    str = gets
    data = []
    str.chars do |v|
      data << v.to_i
    end

    results << (MemorizePi.new data).start

  end

  puts results

end

