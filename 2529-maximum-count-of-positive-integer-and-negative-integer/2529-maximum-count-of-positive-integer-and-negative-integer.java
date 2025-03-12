class Solution 
{
    public int maximumCount(int[] nums) 
    {
        int positive = 0;
        int negative = 0;    

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                continue;
            }

            if(nums[i] < 0)
            {
                negative++;
            }

            if(nums[i] > 0)
            {
                positive++;
            }
        }

        return Math.max(positive, negative);
    }
}