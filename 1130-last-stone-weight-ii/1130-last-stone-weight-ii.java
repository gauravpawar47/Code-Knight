class Solution 
{
    public int helper(int[] stones, int n, int W, Integer[][] dp)
    {
        if(n < 0 || W == 0)
        {
            return 0;
        }

        if(dp[n][W] != null)
        {
            return dp[n][W];
        }

        if(stones[n] <= W)
        {
            int include = stones[n] + helper(stones, n - 1, W - stones[n], dp);
            int exclude = helper(stones, n - 1, W, dp);

            dp[n][W] = Math.max(include, exclude); 
        }
        else
        {
            int exclude = helper(stones, n - 1, W, dp);
            dp[n][W] = exclude;
        }

        return dp[n][W];
    }

    public int lastStoneWeightII(int[] stones) 
    {
        int total = 0;
        for(int s : stones)
        {
            total += s;
        }    

        int n = stones.length;
        int W = total / 2;
        Integer[][] dp = new Integer[n][W + 1];

        int best = helper(stones, n - 1, W, dp);
        return total - 2 * best; 
    }
}