/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution
{
    public int trap(int[] height)
    {
        // Left Max
        int[] leftMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++)
        {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Right Max
        int[] rightMax = new int[height.length];

        rightMax[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
 
        // Trapping Water    
        int trappedWater = 0;

        for(int i = 0; i < height.length; i++)
        {
            int waterLevel = Math.min(leftMax[i], rightMax[i]) - height[i];
            trappedWater += waterLevel;
        }

        return trappedWater;
    }
}
// @lc code=end

