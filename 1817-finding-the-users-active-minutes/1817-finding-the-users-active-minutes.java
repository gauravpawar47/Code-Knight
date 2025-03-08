class Solution 
{
    public int[] findingUsersActiveMinutes(int[][] logs, int k) 
    {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i = 0; i < logs.length; i++)
        {
            int id = logs[i][0];
            int uam = logs[i][1];

            map.putIfAbsent(id, new HashSet<>());
            map.get(id).add(uam);
        }

        int[] result = new int[k];
        for(HashSet<Integer> set : map.values())
        {
            int size = set.size();
            if(size <= k)
            {
                result[size - 1]++;
            }
        }

        return result;
    }
}