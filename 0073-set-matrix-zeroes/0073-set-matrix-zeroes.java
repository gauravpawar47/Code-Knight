class Solution
{
    public void setZeroes(int[][] matrix)
    {
        ArrayList<int[]> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    list.add(new int[]{i, j});
                }
            }
        }    

        for(int[] index : list)
        {
            int row = index[0];
            int col = index[1];
            for(int j = 0; j < n; j++)
            {
                matrix[row][j] = 0;
            }

            for(int i = 0; i < m; i++)
            {
                matrix[i][col] = 0;
            }
        }
    }
}