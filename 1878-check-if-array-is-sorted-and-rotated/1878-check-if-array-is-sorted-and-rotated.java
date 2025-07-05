class Solution 
{
    public boolean check(int[] nums) 
    {
        int bp = -1;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] > nums[i + 1])
            {
                bp = i + 1;
            }
        }

        if(bp == -1)
        {
            return true;
        }

        int i = bp;
        do
        {
            if(nums[i] > nums[(i + 1) % nums.length])
            {
                return false;
            }

            i = (i + 1) % nums.length;
        } while(i != bp - 1);

        return true;
    }
}