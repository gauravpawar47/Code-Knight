class Solution 
{ 
    public void setZeroes(int[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    queue.add(new int[]{i, j});
                }
            }
        }       

        while(!queue.isEmpty())
        {
            int[] curr = queue.remove();
            int i = curr[0];
            int j = curr[1];
            
            for(int row = 0; row < m; row++)
            {
                matrix[row][j] = 0;
            }

            for(int col = 0; col < n; col++)
            {
                matrix[i][col] = 0;
            }
        }
    }
}