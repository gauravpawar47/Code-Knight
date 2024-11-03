/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
import java.util.HashMap;

class Solution
{
    public boolean containsDuplicate(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
    
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                return true;
            }
            map.put(nums[i], 1);
        }

        return false;
    }
}
// @lc code=end

