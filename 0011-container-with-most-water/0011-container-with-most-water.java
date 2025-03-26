class Solution 
{
    public int maxArea(int[] height) 
    {
        int left = 0;
        int right = height.length - 1;
        int container = 0;

        while(left < right)
        {
            int width = right - left;
            int curr = Math.min(height[left], height[right]);

            container = Math.max(container, curr * width);

            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }    

        return container;
    }
}