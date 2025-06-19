class Solution 
{
    public static int helper(int[] cost, int i, int[] dp)
    {
        if(i >= cost.length)
        {
            return 0;
        }

        if(dp[i] != -1)
        {
            return dp[i];
        }

        int oneStep = cost[i] + helper(cost, i + 1, dp);
        int twoStep = (i + 1 < cost.length ? cost[i + 1] : 0) + helper(cost, i + 2, dp);
        dp[i] = Math.min(oneStep, twoStep);

        return Math.min(oneStep, twoStep);
    }

    public int minCostClimbingStairs(int[] cost) 
    {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return helper(cost, 0, dp);
    }
}