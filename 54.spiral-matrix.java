/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startColn = 0;
        int endColn = matrix[0].length - 1;

        while(startRow <= endRow && startColn <= endColn)
        {
            // Top
            for(int j = startColn; j <= endColn; j++)
            {
                list.add(matrix[startRow][j]);
            }

            // Right
            for(int i = startRow + 1; i <= endRow; i++)
            {
                list.add(matrix[i][endColn]);
            }

            // Bottom
            for(int j = endColn - 1; j >= startColn; j--)
            {
                if(startRow == endRow)
                {
                    break;
                }
                list.add(matrix[endRow][j]);
            }

            // Left
            for(int i = endRow - 1; i >= startRow + 1; i--)
            {
                if(startColn == endColn)
                {
                    break;
                }
                list.add(matrix[i][startColn]);
            }

            startRow++;
            endRow--;
            startColn++;
            endColn--;
        }   

        return list;     
    }
}
// @lc code=end

