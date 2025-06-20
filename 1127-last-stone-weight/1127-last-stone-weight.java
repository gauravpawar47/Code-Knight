class Solution 
{
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones)
        {
            pq.offer(n);
        }   

        while(pq.size() > 1)
        {
            int x = pq.poll();
            int y = pq.poll();

            if(y != x)
            {
                pq.offer(x - y);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}