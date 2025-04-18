class Solution 
{
    public int count = 0;
    public void backtrack(int n, int pos, boolean[] visited)
    {
        // Step 1 : Base-Case
        if(pos > n)
        {
            count++;
            return;
        }

        // Step 2 : Kaam
        for(int i = 1; i <= n; i++)
        {
            if(!visited[i] && (i % pos == 0 || pos % i == 0))
            {
                visited[i] = true;

                // Step 3 : Inner Function Call
                backtrack(n, pos + 1, visited);

                // Step 4 : Backtrack Step
                visited[i] = false;
            }
        }


    }

    public int countArrangement(int n) 
    {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }
}