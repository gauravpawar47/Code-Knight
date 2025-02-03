class Solution 
{
    public int isIncreasing(int[] nums, int i) 
    {
        int count = 1; // Start with 1 to include the first element
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) 
        {
            count++;
            i++;
        }
        return count;
    }

    public int isDecreasing(int[] nums, int i) 
    {
        int count = 1; // Start with 1 to include the first element
        while (i < nums.length - 1 && nums[i] > nums[i + 1]) 
        {
            count++;
            i++;
        }
        return count;
    }

    public int longestMonotonicSubarray(int[] nums) 
    {
        int maxLength = 1; // Minimum possible length of a valid subarray
        
        for (int i = 0; i < nums.length - 1; i++) 
        {
            if (nums[i] < nums[i + 1]) 
            {
                maxLength = Math.max(maxLength, isIncreasing(nums, i));
            } 
            else if (nums[i] > nums[i + 1]) 
            {
                maxLength = Math.max(maxLength, isDecreasing(nums, i));
            }
        }

        return maxLength;
    }
}