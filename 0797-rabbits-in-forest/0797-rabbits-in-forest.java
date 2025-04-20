class Solution 
{
    public int numRabbits(int[] answers) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int ans : answers) 
        {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        for (int key : map.keySet()) 
        {
            int count = map.get(key);
            int groupSize = key + 1;
            int groups = (int) Math.ceil((double) count / groupSize);
            total += groups * groupSize;
        }

        return total;
    }
}
