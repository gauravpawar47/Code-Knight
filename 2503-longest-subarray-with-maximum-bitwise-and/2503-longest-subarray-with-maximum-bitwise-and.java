class Solution 
{
    public int longestSubarray(int[] nums) 
    {
        // Step 1: Initialize variables
        int max = 0;
        int ans = 0;
        int curr = 0;

        // Step 2: Traverse the array
        for (int n : nums) 
        {
            if (n > max) 
            {
                // Found a new max, reset streak
                max = n;
                curr = 1;
                ans = 1;
            } 
            else if (n == max) 
            {
                // Same as max, continue the streak
                curr++;
                ans = Math.max(ans, curr);
            } 
            else 
            {
                // Less than max, streak broken
                curr = 0;
            }
        }

        // Step 3: Return the result
        return ans;
    }
}