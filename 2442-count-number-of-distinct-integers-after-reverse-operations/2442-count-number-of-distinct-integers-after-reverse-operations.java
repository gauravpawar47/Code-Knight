class Solution 
{
    public int reversed(int num)
    {
        int n = 0;
        while(num > 0)
        {
            int ld = num % 10;
            n = (n * 10) + ld;
            num /= 10;
        }

        return n;
    }

    public int countDistinctIntegers(int[] nums) 
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
            set.add(reversed(nums[i]));
        }    

        return set.size();
    }
}