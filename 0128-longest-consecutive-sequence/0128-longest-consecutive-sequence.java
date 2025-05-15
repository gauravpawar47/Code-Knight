class Solution 
{
    public int longestConsecutive(int[] nums) 
    {   
        if(nums.length == 0)
        {
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int n : nums)
        {
            set.add(n);
        }   

        ArrayList<Integer> list = new ArrayList<>(set);
        
        int max = 1;
        int count = 1;
        for(int i = 0; i < list.size() - 1; i++)
        {
            if(list.get(i) + 1 == list.get(i + 1))
            {
                count++;
            }
            else
            {
                count = 1;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}