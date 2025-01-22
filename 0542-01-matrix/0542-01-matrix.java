class Solution
{
    public int[][] updateMatrix(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;
        int[][] matrix = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                {
                    matrix[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
                else
                {
                    matrix[i][j] = -1;
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

                    if(I >= 0 && I < m && J >= 0 && J < n && matrix[I][J] == -1)
                    {
                        matrix[I][J] = matrix[i][j] + 1;
                        q.offer(new int[]{I, J});
                    }

                }
            }
        }

        return matrix;
    }
}