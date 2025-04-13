class Solution
{
    public long MOD = 1_000_000_007;

    public long pow(long x, long n)
    {
        // Step 1 : Base-Case
        if(n == 0)
        {
            return 1;
        }

        // Step 2 : Kaam & Inner Function Call
        long halfPower = pow(x, n / 2);
        if(n % 2 == 0)
        {
            return (halfPower * halfPower) % MOD;
        }
        else
        {
            return (halfPower * halfPower * x) % MOD;
        }

    }

    public int countGoodNumbers(long n)
    {
        long even = (n + 1) / 2;
        long odd = (n) / 2;

        long evenHalf = pow(5, even) % MOD;
        long oddHalf = pow(4, odd) % MOD;

        return (int) ((evenHalf * oddHalf) % MOD);
    }
}