class Solution
{
    public int maxSubArray(int[] nums)
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            currSum += nums[i];
            if(currSum < 0)
            {
                currSum = 0;
            }

            maxSum = Math.max(maxSum, currSum);
        }    

        return maxSum == 0 ? maxNegative(nums) : maxSum;
    }

    public int maxNegative(int[] arr)
    {
        if(arr.length == 1)
        {
            return arr[0];
        }

        int maxNeg = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            maxNeg = Math.max(maxNeg, arr[i]);
        }

        return maxNeg;
    }
}