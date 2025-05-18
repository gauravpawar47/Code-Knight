class Solution 
{
    public int minCostConnectPoints(int[][] points) 
    {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0, 0});

        int totalCost = 0;
        int connPoints = 0;

        while(connPoints < n)
        {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int pointIdx = curr[1];

            if(visited[pointIdx])
            {
                continue;
            } 

            visited[pointIdx] = true;
            totalCost += cost;
            connPoints++;

            for(int i = 0; i < n; i++)
            {
                if(!visited[i])
                {
                    int dist = Math.abs(points[pointIdx][0] - points[i][0]) +  
                                Math.abs(points[pointIdx][1] - points[i][1]);

                    minHeap.offer(new int[]{dist, i});
                }
            }
        }    

        return totalCost;
    }
}