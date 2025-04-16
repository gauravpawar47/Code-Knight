class Solution 
{
    public int[] getSneakyNumbers(int[] nums) 
    {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        int j = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(set.contains(nums[i]))
            {
                result[j] = nums[i];
                j++;
            }
            else
            {
                set.add(nums[i]);
            }
        }    

        return result;
    }
}