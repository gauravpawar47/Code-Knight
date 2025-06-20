class Solution 
{
    public boolean canPartition(int[] nums) 
    {
        int sum = 0;
        for(int n : nums)
        {
            sum += n;
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        int n = nums.length;
        int W = sum / 2;    
        boolean[][] dp = new boolean[n + 1][W + 1];

        for(int i = 0; i < n + 1; i++)
        {
            dp[i][0] = true;
        }

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 1; j < W + 1; j++)
            {
                int v = nums[i - 1];
                int wt = j;

                if(v <= wt)
                {
                    if(dp[i - 1][j - v])
                    {
                        dp[i][j] = true;
                    }
                    else if(dp[i - 1][j])
                    {
                        dp[i][j] = true;
                    }
                }
                else if(dp[i - 1][j])
                {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][W];
    }
}