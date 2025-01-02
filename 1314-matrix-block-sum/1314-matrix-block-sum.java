class Solution
{
    public int[][] matrixBlockSum(int[][] mat, int k)
    {
        int n = mat[0].length;
        int m = mat.length;
        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int sum = 0;
                for(int r = Math.max(0, i - k); r <= Math.min(m - 1, i + k); r++)
                {
                    for(int c = Math.max(0, j - k); c <= Math.min(n - 1, j + k); c++)
                    {
                        sum += mat[r][c];
                    }
                }

                result[i][j] = sum;
            }
        }    

        return result;
    }
}