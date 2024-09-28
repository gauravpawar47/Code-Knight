/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution
{
    public int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];

        int digit = 1;
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startColn = 0;
        int endColn = matrix[0].length - 1;

        while(startRow <= endRow && startColn <= endColn)
        {
            // Top
            for(int j = startColn; j <= endColn; j++)
            {
                matrix[startRow][j] = digit;
                digit++;
            }

            // Right
            for(int i = startRow + 1; i <= endRow; i++)
            {
                matrix[i][endColn] = digit;
                digit++;      
            }

            // Bottom
            for(int j = endColn - 1; j >= startColn; j--)
            {
                if(startRow == endRow)
                {
                    break;
                }

                matrix[endRow][j] = digit;
                digit++;
            }

            // Left     
            for(int i = endRow - 1; i >= startRow + 1; i--)
            {
                if(startColn == endColn)
                {
                    break;
                }

                matrix[i][startColn] = digit;
                digit++;
            }

            startRow++;
            endRow--;
            startColn++;
            endColn--; 
        }    

        return matrix;
    }
}
// @lc code=end

