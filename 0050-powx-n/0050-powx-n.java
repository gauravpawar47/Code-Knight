class Solution
{
    public double myPow(double x, int n)
    {
        // Step 1: Handle negative exponent by taking reciprocal
        if (n < 0)
        {
            x = 1 / x;
            // Special case: avoid overflow when `n` is `Integer.MIN_VALUE`
            if (n == Integer.MIN_VALUE)
            {
                n = Integer.MAX_VALUE;
                return x * myPow(x, n);
            }
            n = -n;
        }

        // Step 2: Base case
        if (n == 0)
        {
            return 1;
        }

        // Step 3: Recursive computation
        double halfPower = myPow(x, n / 2);
        if (n % 2 == 0)
        {
            return halfPower * halfPower;
        }
        else
        {
            return halfPower * halfPower * x;
        }
    }
}