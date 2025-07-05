class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int N = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : nums)
        {
            if(n != 0)
            {
                list.add(n);
            }
        }    

        int i = 0;
        while(i < list.size())
        {
            nums[i] = list.get(i);
            i++;
        }

        for(; i < N; i++)
        {
            nums[i] = 0;
        }
    }
}