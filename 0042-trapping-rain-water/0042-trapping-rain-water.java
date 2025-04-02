class Solution
{
    public int trap(int[] height)
    {
        // Step 1 : Calculate Left-Max Boundary
        int n = height.length;
        int[] leftMax = new int[n];

        leftMax[0] = height[0];
        for(int i = 1; i < n; i++)
        {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Step 2 : Calculate Right-Max Boundary
        int[] rightMax = new int[n];

        rightMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--)
        {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // Step 3 : Calculate Trapped Water
        int trappedWater = 0;
        for(int i = 0; i < n; i++)
        {
            int currentWater = Math.min(leftMax[i], rightMax[i]) - height[i]; 
            trappedWater += currentWater;
        }

        return trappedWater;
    }
}