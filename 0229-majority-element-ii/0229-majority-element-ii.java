class Solution 
{
    public List<Integer> majorityElement(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) > nums.length / 3)
            {
                set.add(n);
            }
        }        
        
        return new ArrayList<>(set);
    }
}