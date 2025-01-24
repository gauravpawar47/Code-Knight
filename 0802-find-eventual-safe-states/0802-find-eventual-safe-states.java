class Solution
{
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int n = graph.length;
        int[] safeState = new int[n];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            if(isSafe(graph, i, safeState))
            {
                result.add(i);
            }
        }

        return result;
    }

    public boolean isSafe(int[][] graph, int node, int[] safeState)
    {
        if(safeState[node] == 1)
        {
            return false;
        }

        if(safeState[node] == 2)
        {
            return true;
        }

        safeState[node] = 1;

        for(int neighbors : graph[node])
        {
            if(!isSafe(graph, neighbors, safeState))
            {
                return false;
            }
        }

        safeState[node] = 2;
        return true;
    }
}