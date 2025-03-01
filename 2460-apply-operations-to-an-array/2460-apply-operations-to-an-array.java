class Solution 
{
    public int[] applyOperations(int[] nums) 
    {
        int countZero = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] == nums[i + 1])
            {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }    
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                countZero++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                list.add(nums[i]);
            }
        }

        for(int i = 0; i < list.size(); i++)
        {
            nums[i] = list.get(i);
        }

        for(int i = list.size(); i < nums.length; i++)
        {
            nums[i] = 0;
        }

        return nums;
    }
}