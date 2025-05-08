class Solution 
{
    // Directions for up, down, left, right
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // Helper class to represent each cell in the priority queue
    static class Cell implements Comparable<Cell> 
    {
        int time;
        int row;
        int col;

        Cell(int time, int row, int col) 
        {
            this.time = time;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell other) 
        {
            return Integer.compare(this.time, other.time);
        }
    }

    public int minTimeToReach(int[][] moveTime) 
    {
        // Step 1: Initialize
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] result = new int[m][n]; // stores minimum time to reach each cell
        for (int[] row : result) 
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Step 2: Initialize priority queue and start from (0,0)
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        result[0][0] = 0;
        pq.offer(new Cell(0, 0, 0));

        // Step 3: Dijkstra loop - process nodes in order of increasing time
        while (!pq.isEmpty()) 
        {
            Cell curr = pq.poll();

            // Step 4: If destination is reached, return the time
            if (curr.row == m - 1 && curr.col == n - 1) 
            {
                return curr.time;
            }

            // Step 5: Explore all four directions
            for (int[] dir : directions) 
            {
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];

                // Step 6: Check if the neighbor is within bounds
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) 
                {
                    // Step 7: Calculate move cost (based on (row+col)%2)
                    int moveCost = (newRow + newCol) % 2 == 0 ? 2 : 1;

                    // Step 8: Wait time if the cell is not yet available
                    int wait = Math.max(moveTime[newRow][newCol] - curr.time, 0);

                    // Step 9: Calculate total arrival time
                    int arrivalTime = curr.time + wait + moveCost;

                    // Step 10: Update result and queue if we found a better path
                    if (result[newRow][newCol] > arrivalTime) 
                    {
                        result[newRow][newCol] = arrivalTime;
                        pq.offer(new Cell(arrivalTime, newRow, newCol));
                    }
                }
            }
        }

        // Step 11: Destination not reachable
        return -1;
    }
}