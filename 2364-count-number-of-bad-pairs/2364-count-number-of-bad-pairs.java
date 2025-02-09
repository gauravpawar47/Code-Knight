class Solution
{
    public long countBadPairs(int[] nums) 
    {
        long count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < nums.length; j++)
            {
                if(i < j && j - i != nums[j] - nums[i])
                {
                    count++;
                }
            }
        }       

        return count;
    }
}