class Solution 
{
    public int findLHS(int[] nums) 
    {
        // Step 1: Sort the array
        Arrays.sort(nums);

        int left = 0;
        int maxLen = 0;

        // Step 3: Iterate through the array with right pointer
        for (int right = 0; right < nums.length; right++) 
        {
            // Step 4: Shrink the window if difference > 1
            while (nums[right] - nums[left] > 1) 
            {
                left++;
            }

            // Step 5: If difference == 1, calculate window size
            if (nums[right] - nums[left] == 1) 
            {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // Step 6: Return the result
        return maxLen;
    }
}