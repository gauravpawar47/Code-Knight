class Solution 
{
    public void dfs(List<List<Integer>> rooms, int start, boolean[] visited)
    {
        visited[start] = true;
        for(int i = 0; i < rooms.get(start).size(); i++)
        {
            if(!visited[rooms.get(start).get(i)])
            {
                dfs(rooms, rooms.get(start).get(i), visited);   
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for(boolean b : visited)
        {
            if(!b)
            {
                return b;
            }
        }    

        return true;
    }
}