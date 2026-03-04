class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        TreeSet<Integer> hashed = new TreeSet<>();
        for(int num : nums)
        {
            hashed.add(num);
        }    

        int i = 0;
        for(int num : hashed)
        {
            nums[i] = num;
            i++;
        }

        return hashed.size();
    }
}