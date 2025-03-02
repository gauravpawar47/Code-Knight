class Solution 
{
    public int countPartitions(int[] nums) 
    {
        int[] prefixSum = new int[nums.length];
        int totalSum = 0;

        prefixSum[0] = nums[0];
        totalSum += prefixSum[0];

        for(int i = 1; i < nums.length; i++)
        {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            totalSum += nums[i];
        }

        int evenCount = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if((prefixSum[i - 1] - (totalSum - prefixSum[i - 1])) % 2 == 0)
            {
                evenCount++;
            }
        }

        return evenCount;
    }
}