class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                count++;
                continue;
            }
            result.add(nums[i]);
        }    

        while(count > 0)
        {
            result.add(0);
            count--;
        }

        for(int i = 0; i < nums.length; i++)
        {
            nums[i] = result.get(i);
        }
    }
}