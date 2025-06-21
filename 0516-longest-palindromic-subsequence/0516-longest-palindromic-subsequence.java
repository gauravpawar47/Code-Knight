class Solution 
{
    public int longestPalindromeSubseq(String s) 
    {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++)
        {
            for(int j = 1; j < n + 1; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }  

        return dp[m][n];
    }
}