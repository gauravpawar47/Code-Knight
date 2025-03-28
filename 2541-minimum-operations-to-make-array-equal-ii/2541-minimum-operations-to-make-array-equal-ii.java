class Solution 
{
    public long minOperations(int[] nums1, int[] nums2, int k) 
    {
        int n = nums1.length;
        long posSum = 0, negSum = 0;

        for(int i = 0; i < n; i++)
        {
            int diff = nums2[i] - nums1[i];

            if(k > 0 && diff % k != 0) 
            {
                return -1;
            }

            if(diff > 0) 
            {
                posSum += diff / k;
            }
            else if(diff < 0) 
            {
                negSum += -diff / k;  // Convert negative diff to positive
            }
        }

        return (posSum == negSum) ? posSum : -1;
    }
}