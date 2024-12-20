/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 */

// @lc code=start
class Solution
{
    public boolean rotateString(String s, String goal)
    {
        return s.length() == goal.length() && (s + s).contains(goal);        
    }
}
// @lc code=end

