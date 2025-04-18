class Solution 
{
    public int[][] modifiedMatrix(int[][] matrix) 
    {
        // Step 1 : Initialize the Iterators
        int m = matrix.length;
        int n = matrix[0].length;
        int[] max = new int[n];

        // Step 2 : Find the max of each Column
        for(int j = 0; j < n; j++)
        {
            for(int i = 0; i < m; i++)
            {
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }

        // Step 3 : Assign appropriate max to column 
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == -1)
                {
                    matrix[i][j] = max[j];
                }
            }
        }

        return matrix;
    }
}