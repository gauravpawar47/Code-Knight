class Solution 
{
    public int[][] onesMinusZeros(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = new int[m][n];

        int[] rowOne = new int[m];
        for(int i = 0; i < m; i++)
        {
            int rowCount = 0;
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    rowCount++;
                }
            }
            rowOne[i] = rowCount;
        }

        int[] colOne = new int[n];
        for(int j = 0; j < n; j++)
        {
            int colCount = 0;
            for(int i = 0; i < m; i++)
            {
                if(grid[i][j] == 1)
                {
                    colCount++;
                }
            }
            colOne[j] = colCount;
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int row1 = rowOne[i];
                int col1 = colOne[j];
                int row0 = m - rowOne[i];
                int col0 = n - colOne[j];

                diff[i][j] = (row1 + col1) - (row0 + col0); 
            }
        }    

        return diff;
    }
}