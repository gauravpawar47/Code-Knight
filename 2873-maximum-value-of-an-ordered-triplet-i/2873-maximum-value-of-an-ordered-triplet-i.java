class Solution 
{
    public long maximumTripletValue(int[] nums) 
    {
        int n = nums.length;
        if(n < 3)
        {
            return 0;
        }
    
        long maxTriplet = Long.MIN_VALUE;
        for(int i = 0; i < n - 2; i++)
        {
            for(int j = i + 1; j < n - 1; j++)
            {
                long diff = (long) nums[i] - nums[j];
                long maxK = Long.MIN_VALUE;

                for(int k = j + 1; k < n; k++)
                {
                    maxK = Math.max(maxK, nums[k]);
                }

                maxTriplet = Math.max(maxTriplet, diff * maxK);
            }
        }

        return Math.max(0, maxTriplet);
    }
}