class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int row = 0;
        int coln = matrix[0].length - 1;

        while(row <= matrix.length - 1 && coln >= 0)
        {
            if(matrix[row][coln] == target)
            {
                return true;
            }
            else if(matrix[row][coln] > target)
            {
                coln--;
            }
            else
            {
                row++;
            }
        }
        return false;
    }
}