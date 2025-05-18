class Solution 
{
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < edges.size(); i++)
        {
            List<Integer> curr = edges.get(i);
            set.add(curr.get(1));
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(!set.contains(i))
            {
                list.add(i);
            }
        }

        return list;
    }
}