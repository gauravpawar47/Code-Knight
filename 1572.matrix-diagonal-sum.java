/*
 * @lc app=leetcode id=1572 lang=java
 *
 * [1572] Matrix Diagonal Sum
 */

// @lc code=start
class Solution
{
    public int diagonalSum(int[][] mat)
    {
        int sum = 0;
        for(int i = 0; i < mat[0].length; i++)
        {
            sum += mat[i][i];
         
            if(i != mat.length - i - 1)
            {
                sum += mat[i][mat.length - i - 1];
            }
        }    
        return sum;
    }
}
// @lc code=end

