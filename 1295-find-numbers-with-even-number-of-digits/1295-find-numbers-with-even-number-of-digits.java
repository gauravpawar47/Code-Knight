class Solution 
{
    public int findNumbers(int[] nums) 
    {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(getCount(nums[i]) % 2 == 0)
            {
                count++;
            }
        }    

        return count;
    }

    public int getCount(int n)
    {
        int count = 0;
        while(n > 0)
        {
            count++;
            n /= 10;
        }

        return count;
    }
}