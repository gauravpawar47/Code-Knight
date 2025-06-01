class Solution 
{
    public long distributeCandies(int n, int limit) 
    {
        // Step 4: Check impossibility
        if (n > 3L * limit)
        {
            return 0;
        } 

        // Step 3: Inclusion-exclusion formula
        long total = comb(n + 2, 2)                      // total without limits
                   - 3L * comb(n - limit + 1, 2)        // subtract solutions 
                   + 3L * comb(n - 2 * limit, 2)        // add solutions violating
                   - comb(n - 3 * limit - 1, 2);        // subtract solutions 

        // Ensure non-negative result
        return Math.max(total, 0);
    }

    // Step 1 & 2: Compute n choose k (combination) safely
    private long comb(long n, long k) 
    {
        if (n < 0 || k < 0 || n < k)
        {
            return 0;
        }

        long res = 1;
        for (long i = 1; i <= k; i++) 
        {
            res = res * (n - i + 1) / i;
        }
        
        return res;
    }
}