class Solution 
{
    public int majorityElement(int[] nums) 
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }    

        int n = nums.length;
        for(int key : map.keySet())
        {
            if(map.get(key) > n / 2)
            {
                return key;
            }
        }

        return -1;
    }
}