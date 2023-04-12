class MedianFinder {
    
    PriorityQueue <Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
         minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else{
            minHeap.add(num);
        }
        //Either both the heap will have equal number of elements or 
        //maxHeap will have one more element than the minHeap;
        
        if(maxHeap.size()>minHeap.size()+1)
            minHeap.add(maxHeap.poll());
        else if(maxHeap.size()<minHeap.size())
            maxHeap.add(minHeap.poll());
            
        
    }
    
    public double findMedian() {
        //when even number of elements are present
        if(maxHeap.size()==minHeap.size())
            return maxHeap.peek()/2.0+minHeap.peek()/2.0;
        
        //when odd number of elements are present
        return maxHeap.peek();
    }
}