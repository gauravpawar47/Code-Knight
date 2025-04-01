class Solution 
{
    public long mostPoints(int[][] questions) 
    {
        int n = questions.length;
        long nextBest = 0;  // Equivalent to dp[i+1]
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) 
        {
            int points = questions[i][0];
            int brainpower = questions[i][1];

            // Solve the current question and jump
            long solve = points + (i + brainpower + 1 < n ? dp[i + brainpower + 1] : 0);

            // Store the best choice
            dp[i] = Math.max(solve, nextBest);
            nextBest = dp[i];  // Update nextBest for next iteration
        }

        return dp[0];
    }
}