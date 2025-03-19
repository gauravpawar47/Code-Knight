class Solution 
{
    public int minOperations(int[] nums) 
    {
        int op = 0;
        for (int i = 0; i <= nums.length - 3; i++) 
        {
            if (nums[i] == 0) 
            {
                for (int j = i; j < i + 3; j++) 
                {
                    nums[j] ^= 1;
                }

                op++;
            }
        }

        for (int num : nums) 
        {
            if (num == 0)
            {
                return -1;
            } 
        }

        return op;
    }
}