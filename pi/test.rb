#!/usr/bin/bash ruby

require File.join(File.dirname(__FILE__) , 'pi')

if __FILE__ == $0 then

  start_time = Time.new
  results = []
  50.times do |index|
    data = []
    data_size = 5000
    data_size.times do
      data << Random.rand(7)+1
    end
    results << (MemorizePi.new data).start
  end

  end_time = Time.new
  puts end_time - start_time


  p1 = MemorizePi.new [1,2,3,4,1,2,3,4]
  p2 = MemorizePi.new [1,1,1,1,1,2,2,2]
  p3 = MemorizePi.new [1,2,1,2,2,2,2,2]
  p4 = MemorizePi.new [2,2,2,2,2,2,2,2]
  p5 = MemorizePi.new [1,2,6,7,3,9,3,9]

  puts p1.start
  puts p2.start
  puts p3.start
  puts p4.start
  puts p5.start


end


