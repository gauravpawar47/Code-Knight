class Solution 
{
    public List<Integer> majorityElement(int[] nums) 
    {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) > n / 3)
            {
                set.add(i);
            }
        }    

        return new ArrayList<>(set);
    }
}