class Solution 
{
    public boolean checkXMatrix(int[][] grid) 
    {
        boolean diagonal = true;
        boolean corners = true;

        for(int i = 0; i < grid.length; i++)
        {
            if(grid[i][i] == 0 || grid[i][grid.length - i - 1] == 0)
            {
                diagonal = false;
                break;
            }
        }    

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                if(i == j || j == grid.length - i - 1)
                {
                    continue;
                }

                if(grid[i][j] != 0)
                {
                    corners = false;
                    break;
                }

                if(!corners)
                {
                    break;
                }
            }
            
        }        

        return corners && diagonal;
    }
}