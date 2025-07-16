class Solution 
{
    static class Pair implements Comparable<Pair>
    {
        char idx;
        int count;

        public Pair(char idx, int count)
        {
            this.idx = idx;
            this.count = count;
        } 

        public int compareTo(Pair p)
        {
            if(p.count != this.count)
            {
                return p.count - this.count;
            }
            else
            {
                return this.idx - p.idx;
            }
        }
    }

    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            char ch = p.idx;
            int c = p.count;

            while(c > 0)
            {
                sb.append(ch);
                c--;
            }
        }

        return sb.toString();
    }
}