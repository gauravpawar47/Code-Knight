class Solution 
{
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int max = 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++)
        {   
            if(nums[i] == 1)
            {
                curr += 1;
            }
            else
            {
                max = Math.max(max, curr);
                curr = 0;
            }
        }

        return Math.max(curr, max);
    }
}