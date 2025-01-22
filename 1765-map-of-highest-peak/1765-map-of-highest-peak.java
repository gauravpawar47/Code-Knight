class Solution
{
    public int[][] highestPeak(int[][] isWater)
    {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(isWater[i][j] == 1)
                {
                    height[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
                else
                {
                    height[i][j] = -1;
                }
            }
        }   

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty())
        {
            int N = q.size();
            while(N-- > 0)
            {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for(int[] dir : directions)
                {
                    int I = i + dir[0];
                    int J = j + dir[1];

                    if(I >= 0 && I < m && J >= 0 && J < n && height[I][J] == -1)
                    {
                        height[I][J] = height[i][j] + 1;
                        q.offer(new int[]{I, J});
                    }
                }
            }
        }
        
        return height;
    }
}