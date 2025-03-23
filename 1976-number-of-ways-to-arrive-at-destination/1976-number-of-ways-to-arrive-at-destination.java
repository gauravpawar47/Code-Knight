class Solution 
{
    static class Pair 
    {
        int node;
        long weight; 

        public Pair(int node, long weight) 
        {
            this.node = node;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] roads) 
    {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) 
        {
            int u = road[0], v = road[1];
            long w = road[2]; 

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.weight));
        
        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));
        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) 
        {
            Pair curr = pq.poll();
            int currNode = curr.node;
            long currDist = curr.weight;

            // Skip if we have already found a shorter distance
            if (currDist > dist[currNode])
            {
                continue;
            } 

            // Process neighbors
            for (Pair neighbor : adj.get(currNode)) 
            {
                int nextNode = neighbor.node;
                long edgeWeight = neighbor.weight;

                if (currDist + edgeWeight < dist[nextNode]) 
                {
                    dist[nextNode] = currDist + edgeWeight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                    ways[nextNode] = ways[currNode]; // Reset path count
                }
                else if (currDist + edgeWeight == dist[nextNode]) 
                {
                    ways[nextNode] = (ways[nextNode] + ways[currNode]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}