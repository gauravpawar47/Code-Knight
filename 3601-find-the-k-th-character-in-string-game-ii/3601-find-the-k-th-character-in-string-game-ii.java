class Solution 
{
    public char kthCharacter(long k, int[] operations) 
    {
        // Step 1: Calculate the final length of the string (n = 2^m)
        long n = 1;
        int i = 0;
        while (n < k) 
        {
            n <<= 1; // equivalent to n *= 2
            i++;
        }

        // Step 2: Initialize shift counter
        int d = 0;

        // Step 3: Reverse simulate the operations
        while (n > 1) 
        {
            long half = n >> 1; // current length / 2
            if (k > half) 
            {
                k -= half; // came from second half
                d += operations[i - 1]; // shift applied if op was 1
            }
            
            n = half; // move to previous stage (first half)
            i--;
        }

        // Step 4: Apply total shift to the original 'a'
        return (char) ('a' + (d % 26));
    }
}