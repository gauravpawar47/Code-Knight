public class Solution 
{
    public int longestSubsequence(String s, int k) 
    {
        // Step 1: Count all zeros (they're always safe to include)
        int zeros = 0;
        for (char c : s.toCharArray()) 
        {
            if (c == '0')
            {
                zeros++;
            } 
        }

        // Step 2: Initialize variables
        long value = 0;
        int power = 0;
        int count = 0;

        // Step 3: Traverse from right to left
        for (int i = s.length() - 1; i >= 0 && power < 32; i--) 
        {
            if (s.charAt(i) == '1') 
            {
                // Step 4: Try adding '1' if value stays within k
                value += 1L << power;
                if (value > k)
                {
                    break;
                }

                count++;
                power++;
            } 
            else 
            {
                // Step 5: Just move to next power
                power++;
            }
        }

        // Step 6: Return total count (safe 0s + allowed 1s)
        return count + zeros;
    }
}