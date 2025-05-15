class Solution 
{
    public int[] numberOfPairs(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int pairs = 0;
        int leftOver = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pairs += entry.getValue() / 2;
            leftOver += entry.getValue() % 2;
        }

        return new int[]{pairs, leftOver};
    }
}