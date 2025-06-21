class Solution 
{
    static final int MOD = 1_000_000_007;
    public int memo(int i, int j, String s, int[][] dp)
    {
        if(i > j)
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int ans = 0;
        for(char ch = 'a'; ch <= 'd'; ch++)
        {
            int l = i;
            int r = j;

            while(l <= j && s.charAt(l) != ch)
            {
                l++;
            }

            while(r >= i && s.charAt(r) != ch)
            {
                r--;
            }

            if(l > r)
            {
                continue;
            }
            else if(l == r)
            {
                ans = (ans + 1) % MOD;
            }
            else
            {
                ans = (ans + 2 + memo(l + 1, r - 1, s, dp)) % MOD;
            }
        }

        dp[i][j] = ans;
        return ans;
    }

    public int countPalindromicSubsequences(String s) 
    {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int[] row : dp)
        {
            Arrays.fill(row, - 1);
        }

        return memo(0, n - 1, s, dp);
    }
}