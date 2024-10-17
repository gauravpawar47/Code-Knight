/*
 * @lc app=leetcode id=1684 lang=java
 *
 * [1684] Count the Number of Consistent Strings
 */

// @lc code=start
class Solution
{
    public int countConsistentStrings(String allowed, String[] words)
    {
        int count = 0;
        for(int i = 0; i < words.length; i++)
        {
            String curr = words[i];
            for(int j = 0; j < allowed.length(); j++)
            {
                curr = curr.replace(Character.toString(allowed.charAt(j)), "");
            }
            
            if(curr.length() == 0)
            {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

