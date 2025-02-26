class Solution
{
    public int maxAbsoluteSum(int[] nums)
    {
        int maxSum = 0, minSum = 0, maxAbsSum = 0;
        int currentMax = 0, currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            currentMin = Math.min(num, currentMin + num);
            maxAbsSum = Math.max(maxAbsSum, Math.max(currentMax, -currentMin));
        }

        return maxAbsSum;
    }
}
