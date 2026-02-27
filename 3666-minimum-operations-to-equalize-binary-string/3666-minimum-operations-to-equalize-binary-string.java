class Solution 
{
    public int ceil(int x, int y) 
    {
        return (x + y - 1) / y;
    }

    public int minOperations(String S, int K) 
    {
        int N = S.length();
        int Z = 0;

        for (char c : S.toCharArray()) 
        {
            if (c == '0')
            {
                Z++;
            } 
        }

        if (N == K) 
        {
            if (Z == 0)
            {
                return 0;
            } 
            if (Z == N) 
            {
                return 1;
            }

            return -1;
        }

        int ans = Integer.MAX_VALUE;
        if (Z % 2 == 0) 
        {
            int M = Math.max(ceil(Z, K), ceil(Z, N - K));
            if (M % 2 == 1)
            {
                M++;
            } 

            ans = Math.min(ans, M);
        }

        if (Z % 2 == K % 2) 
        {
            int M = Math.max(ceil(Z, K), ceil(N - Z, N - K));
            if (M % 2 == 0)
            {
                M++;
            } 

            ans = Math.min(ans, M);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}