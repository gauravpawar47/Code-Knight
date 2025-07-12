class Solution 
{
    public boolean isAllNegative(int[] nums)
    {
        for(int n : nums)
        {
            if(n > 0)
            {
                return false;
            }
        }

        return true;
    }

    public int smallestNegative(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        for(int n : nums)
        {
            min = Math.min(min, Math.abs(n));
        }

        return min;
    }
    
    public int maxSubArray(int[] nums) 
    {
        if(isAllNegative(nums))
        {
            return -smallestNegative(nums);
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(sum < 0)
            {
                sum = 0;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}