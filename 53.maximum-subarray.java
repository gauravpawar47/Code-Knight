/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution
{
    public int maxSubArray(int[] nums)
    {
        int currentSum = 0;
        int maxSum = nums[0];

        for(int i = 0; i < nums.length; i++)
        {
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0)
            {
                currentSum = 0;
            }
        }    

        return maxSum;
    }
}
// @lc code=end

