/*
 * @lc app=leetcode id=1929 lang=java
 *
 * [1929] Concatenation of Array
 */

// @lc code=start
class Solution
{
    public int[] getConcatenation(int[] nums)
    {
        int[] arr = new int[nums.length * 2];

        for(int i = 0; i < nums.length * 2; i++)
        {
            if(i  <= nums.length - 1)
            {
                arr[i] = nums[i];
            }
            else
            {
                arr[i] = nums[i - nums.length];
            }
        }    

        return arr;
    }
}
// @lc code=end

