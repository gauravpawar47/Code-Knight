class Solution 
{
    public int[] rearrangeArray(int[] nums) 
    {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];

        int i = 0;
        int j = 0;

        for(int n : nums)
        {
            if(n > 0)
            {
                pos[i] = n;
                i++;
            }
            else
            {
                neg[j] = n;
                j++;
            }
        }    

        i = 0;
        j = 0;

        for(int n = 0; n < nums.length; n++)
        {
            if(n % 2 == 0)
            {
                nums[n] = pos[i];
                i++; 
            }
            else
            {
                nums[n] = neg[j];
                j++;
            }
        }

        return nums;
    }
}