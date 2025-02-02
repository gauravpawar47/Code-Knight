class Solution 
{
    public boolean check(int[] nums) 
    {
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] > nums[i + 1])
            {
                return isRotated(nums, i + 1, nums.length - 1, 0);
            }
        }

        return true;
    }

    public boolean isRotated(int[] nums, int start, int end, int i)
    {
        for(int j = start; j < end; j++)
        {
            if(nums[j] > nums[j + 1])
            {
                return false;
            }
        }

        return nums[end] <= nums[i];
    }
}