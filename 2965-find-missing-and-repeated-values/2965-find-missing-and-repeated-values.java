class Solution 
{
    public int[] findMissingAndRepeatedValues(int[][] grid) 
    {
        int n = grid.length;
        int[] map = new int[n * n + 1];
        int[] ans = new int[2];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                map[grid[i][j]]++;
            }
        }    

        for(int i = 1; i < map.length; i++)
        {   
            if(map[i] == 2)
            {
                ans[0] = i;
            }

            if(map[i] == 0)
            {
                ans[1] = i;
            }
        }

        return ans;
    }
}