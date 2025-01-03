class Solution
{
    public int findMiddleIndex(int[] nums)
    {
        // Step 1 : Calculate Left Sum
        int[] leftSum = new int[nums.length];
        leftSum[0] = nums[0]; 

        for(int i = 1; i < nums.length; i++)
        {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        // Step 2 : Calculate Right Sum
        int[] rightSum = new int[nums.length];
        rightSum[nums.length - 1] = nums[nums.length - 1]; 

        for(int i = nums.length - 2; i >= 0; i--)
        {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        // Step 3 : Find the Same Sum and Return it
        for(int i = 0; i < rightSum.length; i++)
        {
            if(leftSum[i] == rightSum[i])
            {
                return i;
            }
        }

        return -1;
    }
}