class Solution 
{
    public int minStoneSum(int[] piles, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int n : piles)
        {
            pq.offer(n);
        }    

        while(k > 0)
        {
            int c = (int) Math.ceil(pq.poll() / 2.0);
            pq.offer(c);
            k--;
        }

        int sum = 0;
        while(!pq.isEmpty())
        {
            sum += pq.poll();
        }

        return sum;
    }
}