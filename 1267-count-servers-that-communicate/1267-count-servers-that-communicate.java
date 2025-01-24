class Solution
{
    public int countServers(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
    
        int server = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {                if(grid[i][j] == 1 && checkIsolated(i, j, grid))
                {
                    server++;
                }
            }
        }
    }

    public boolean checkIsolated(int row, int coln, int[][] grid)
    {
        for(int i = 0; i < grid.length; i++)
        {
            if(grid[i][coln] == 1)
            {
                return true;
            }
        }

        for(int j = 0; j < grid[0].length; j++)
        {
            if(grid[row][j] == 1)
            {
                return true;
            }
        }

        return false;
    }
}