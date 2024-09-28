/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
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
// @lc code=end

