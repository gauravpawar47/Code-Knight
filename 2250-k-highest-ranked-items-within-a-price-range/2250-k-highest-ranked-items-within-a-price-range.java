class Solution 
{
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int low = pricing[0];
        int high = pricing[1];
        
        int startRow = start[0];
        int startCol = start[1];

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        // Min-heap based on the ranking criteria
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // distance
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // price
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]); // row
            return Integer.compare(a[3], b[3]);                   // col
        });

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        int distance = 0;

        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) 
            {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                if (grid[r][c] >= low && grid[r][c] <= high) 
                {
                    pq.offer(new int[]{distance, grid[r][c], r, c});
                }

                for (int[] dir : directions) 
                {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                        grid[nr][nc] != 0 && !visited[nr][nc]) 
                    {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            distance++;
        }

        while (!pq.isEmpty() && result.size() < k) 
        {
            int[] item = pq.poll();
            result.add(Arrays.asList(item[2], item[3]));
        }

        return result;
    }
}