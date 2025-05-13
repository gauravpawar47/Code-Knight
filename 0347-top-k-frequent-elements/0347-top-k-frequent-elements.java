class Solution 
{
    public class Pair
    {
        int n;
        int f;

        Pair(int n, int f)
        {
            this.n = n;
            this.f = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.f - a.f);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++)
        {
            result[i] = pq.poll().n;
        }

        return result;
    }
}