
class QuadTree

  def upsideDown(quadTree, index)
    ch = quadTree[index]

    if ch == 'x'
      index += 1
      lt = upsideDown(quadTree, index)
      index += lt.length
      rt = upsideDown(quadTree, index)
      index += rt.length
      ld = upsideDown(quadTree, index);
      index += ld.length
      rd = upsideDown(quadTree, index);
      return "x"+ld+rd+lt+rt;
    end

    ch
  end

end

if __FILE__ == $0

  #input = File.open "../test.txt"
  input = Kernel

  testCount = input.gets.to_i
  qt = QuadTree.new

  testCount.times do
    puts qt.upsideDown(input.gets , 0)
  end

end