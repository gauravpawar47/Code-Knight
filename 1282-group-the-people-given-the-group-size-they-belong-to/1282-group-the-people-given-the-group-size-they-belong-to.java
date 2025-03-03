class Solution 
{
    public List<List<Integer>> groupThePeople(int[] groupSizes) 
    {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++)
        {
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            int groupSize = entry.getKey();
            ArrayList<Integer> tuple = entry.getValue();

            for(int i = 0; i < tuple.size(); i += groupSize)
            {
                result.add(new ArrayList<>(tuple.subList(i, Math.min(i + groupSize, tuple.size()))));
            }
        }

        return result;
    }
}