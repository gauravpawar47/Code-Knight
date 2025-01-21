class Solution
{
    public long gridGame(int[][] grid)
    {
        long firstRowRemain = 0;
        for(long num : grid[0])
        {
            firstRowRemain += num;
        }   

        long secondRowRemain = 0;
        long minRobot2 = Long.MAX_VALUE;

        for(int r1col = 0; r1col < grid[0].length; r1col++)
        {
            firstRowRemain -= grid[0][r1col];
            long bestOfRobot2 = Math.max(firstRowRemain, secondRowRemain);
            
            minRobot2 = Math.min(minRobot2, bestOfRobot2);
            secondRowRemain += grid[1][r1col];
        }

        return minRobot2;
    }
}