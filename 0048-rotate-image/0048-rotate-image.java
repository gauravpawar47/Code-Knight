class Solution 
{
    public void rotate(int[][] matrix) 
    {
        int n = matrix.length;
        int[][] result = new int[n][n];
        int j = n - 1;
        for(int[] row : matrix)
        {
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                result[i][j] = row[k];
                k++;
            }
            j--;
        }    

        for(int i = 0; i < n; i++)
        {
            for(j = 0; j < n; j++)
            {
                matrix[i][j] = result[i][j];
            }
        }
    }
}