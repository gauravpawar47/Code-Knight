class Solution 
{
    public Set<String> visited = new HashSet<>();
    public StringBuilder result = new StringBuilder();
    public int k;

    public String crackSafe(int n, int k) 
    {
        this.k = k;
        StringBuilder start = new StringBuilder();
        for(int i = 0; i < n - 1; i++)
        {
            start.append("0");
        }        

        String node = start.toString();
        dfs(node);
        result.append(node);

        return result.toString();
    }

    public void dfs(String node)
    {
        for(int i = 0; i < k; i++)
        {
            String edge = node + i;
            if(!visited.contains(edge))
            {
                visited.add(edge);
                dfs(edge.substring(1));
                result.append(i);
            }
        }
    }
}