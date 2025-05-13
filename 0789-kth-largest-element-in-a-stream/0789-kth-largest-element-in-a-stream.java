class KthLargest 
{
    public PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) 
    {
        pq = new PriorityQueue<>();
        K = k;

        for(int n : nums)
        {
            pq.add(n);
        }
    }
    
    public int add(int val) 
    {
        pq.offer(val);
        while(pq.size() > K)
        {
            pq.remove();
        }    

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */