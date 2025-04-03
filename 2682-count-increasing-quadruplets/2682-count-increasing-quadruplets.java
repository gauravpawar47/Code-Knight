class Solution 
{
    public long countQuadruplets(int[] nums) 
    {
        int n = nums.length;
        long[] count = new long[n];

        long ans = 0;
        for(int i = 0; i < n; i++)
        {
            int prevSmall = 0;
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    prevSmall++;
                    ans += count[j];
                }
                else if(nums[j] > nums[i])
                {
                    count[j] += prevSmall;
                }
            }
        }

        return ans;
    }
}