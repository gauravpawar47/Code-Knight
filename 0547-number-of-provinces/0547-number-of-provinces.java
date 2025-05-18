class Solution 
{
    public void dfs(int city, int[][] isConnected, boolean[] visited)
    {
        visited[city] = true;
        for(int i = 0; i < isConnected.length; i++)
        {
            if(isConnected[city][i] == 1 && !visited[i])
            {
                dfs(i, isConnected, visited);
            }
        }
    }    

    public int findCircleNum(int[][] isConnected) 
    {
        int provinceCount = 0;
        boolean[] visited = new boolean[isConnected.length];

        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visited[i])
            {
                dfs(i, isConnected, visited);
                provinceCount++;
            }
        }

        return provinceCount;
    }
}