/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution
{
    public int singleNumber(int[] nums)
    {
        if(nums.length == 1)
        {
            return nums[0];
        }    

        int result = 0;
        for(int i = 0; i < nums.length; i++)
        {
            result = result ^ nums[i];
        }

        return result;
    }
}
// @lc code=end

