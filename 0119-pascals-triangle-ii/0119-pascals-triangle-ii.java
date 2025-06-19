class Solution 
{
    public List<Integer> getRow(int rowIndex) 
    {
        List<List<Integer>> result = new ArrayList<>();
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];

        for(int i = 0; i <= rowIndex; i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++)
            {
                if(j == 0 || j == i)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }

                list.add(dp[i][j]);
            }

            result.add(list);
        }     

        // Return
        return result.get(rowIndex);
    }
}