class Solution 
{
    int[] subtreeXor;
    int[] tin;
    int[] tout;
    int[] parent;
    int timer;
    List<Integer>[] graph;

    public int minimumScore(int[] nums, int[][] edges) 
    {
        int n = nums.length;
        subtreeXor = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; ++i)
        {
            graph[i] = new ArrayList<>();
        } 

        for (int[] edge : edges) 
        {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        timer = 0;
        dfs(0, -1, nums);

        int totalXor = subtreeXor[0];

        // Identify child nodes in edges for consistent orientation
        int[][] edgeEnds = new int[edges.length][2];
        for (int i = 0; i < edges.length; ++i) 
        {
            int u = edges[i][0], v = edges[i][1];
            if (parent[v] == u)
            {
                edgeEnds[i] = new int[]{u, v};
            } 
            else
            {
                edgeEnds[i] = new int[]{v, u};
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; ++i) 
        {
            int a = edgeEnds[i][1];
            for (int j = i + 1; j < edges.length; ++j) 
            {
                int b = edgeEnds[j][1];
                int comp1;
                int comp2;
                int comp3;
                
                if (isAncestor(a, b)) 
                {
                    comp1 = subtreeXor[b];
                    comp2 = subtreeXor[a] ^ subtreeXor[b];
                    comp3 = totalXor ^ subtreeXor[a];
                } 
                else if (isAncestor(b, a)) 
                {
                    comp1 = subtreeXor[a];
                    comp2 = subtreeXor[b] ^ subtreeXor[a];
                    comp3 = totalXor ^ subtreeXor[b];
                } 
                else 
                {
                    comp1 = subtreeXor[a];
                    comp2 = subtreeXor[b];
                    comp3 = totalXor ^ subtreeXor[a] ^ subtreeXor[b];
                }
                
                int maxVal = Math.max(comp1, Math.max(comp2, comp3));
                int minVal = Math.min(comp1, Math.min(comp2, comp3));
                ans = Math.min(ans, maxVal - minVal);
            }
        }

        return ans;
    }

    public void dfs(int node, int par, int[] nums) 
    {
        tin[node] = ++timer;
        subtreeXor[node] = nums[node];
        parent[node] = par;
        
        for (int nei : graph[node]) 
        {
            if (nei == par)
            {
                continue;
            } 
            dfs(nei, node, nums);
            subtreeXor[node] ^= subtreeXor[nei];
        }

        tout[node] = ++timer;
    }

    public boolean isAncestor(int u, int v) 
    {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }
}