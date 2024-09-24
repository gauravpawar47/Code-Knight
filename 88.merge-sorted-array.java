/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
import java.util.Arrays;

class Solution
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        if(nums1.length < 0 || nums2.length < 0)
        {
            return;
        }   

        int[] result = new int[m + n];
        for(int i = 0; i < nums1.length; i++)
        {
            result[i] = nums1[i];
        }

        for(int i = 0; i < nums2.length; i++)
        {
            result[i + m] = nums2[i];
        }

        Arrays.sort(result);
        for(int i = 0; i < result.length; i++)
        {
            nums1[i] = result[i];
        }
    }
}
// @lc code=end

