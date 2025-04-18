class Solution 
{
    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result)
    {
        // Step 1 : Base-Case
        if(node == graph.length - 1)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        // Step 2 : Kaam
        for(int neighbor : graph[node])
        {
            path.add(neighbor);
         
            // Step 3 : Inner Function Call
            dfs(graph, neighbor, path, result);

            // Step 4 : Backtrack Step
            path.remove(path.size() - 1); 
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        current.add(0);
        dfs(graph, 0, current, result);
        return result;    
    }
}