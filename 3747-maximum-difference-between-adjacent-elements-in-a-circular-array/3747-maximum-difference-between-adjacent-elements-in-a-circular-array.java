class Solution 
{
    public int maxAdjacentDistance(int[] nums) 
    {
        // Step 1: Initialize maxDiff to a very small value
        int maxDiff = Integer.MIN_VALUE;

        // Step 2: Loop through array and compute differences between adjacent elements
        for (int i = 1; i < nums.length; i++) 
        {
            int diff = Math.abs(nums[i - 1] - nums[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        // Step 3: Check the circular difference (last and first element)
        int circularDiff = Math.abs(nums[0] - nums[nums.length - 1]);
        maxDiff = Math.max(maxDiff, circularDiff);

        // Step 4: Return the maximum difference found
        return maxDiff;
    }
}