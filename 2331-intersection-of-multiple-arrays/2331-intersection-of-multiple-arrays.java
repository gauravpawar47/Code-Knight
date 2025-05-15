class Solution 
{
    public List<Integer> intersection(int[][] nums) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums[0])
        {
            set.add(n);
        }

        for(int i = 1; i < nums.length; i++)
        {
            HashSet<Integer> current = new HashSet<>();
            for(int n : nums[i])
            {
                current.add(n);
            }

            set.retainAll(current);
        }    

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}