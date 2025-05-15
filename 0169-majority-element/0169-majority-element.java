class Solution 
{
    public int majorityElement(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int freq = nums.length / 2;
        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) > freq)
            {
                return n;
            }
        }       

        return -1;
    }
}