class Solution 
{   
    public boolean hasDuplicates(int[] nums, int start)
    {
        int[] freq = new int[101];
        for(int i = start; i < nums.length; i++)
        {
            if(freq[nums[i]] == 1)
            {
                return false;
            }

            freq[nums[i]]++;
        }

        return true;
    }

    public int minimumOperations(int[] nums) 
    {
        int op = 0;
        int i = 0;
        while(i < nums.length)
        {
            if(hasDuplicates(nums, i))
            {
                break;
            }

            op++;
            i += 3;
        }
        return op;
    }
}