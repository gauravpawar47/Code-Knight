class Solution
{
    public boolean isMatrixEqual(int[][] mat, int[][] target)
    {
        int n = mat.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] != target[i][j])
                {
                    return false;
                }
            }
        }

        return true;
    }

    public int[][] rotate(int[][] mat)
    {
        int n = mat.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                result[j][n - i - 1] = mat[i][j];
            }
        }

        return result;
    }

    public boolean findRotation(int[][] mat, int[][] target)
    {
        int n = mat.length;
        for(int i = 0; i < 4; i++)
        {
            if(isMatrixEqual(mat, target))
            {
                return true;
            }
            mat = rotate(mat);
        }

        return false;
    }
}