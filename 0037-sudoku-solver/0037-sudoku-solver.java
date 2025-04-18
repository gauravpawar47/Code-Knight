class Solution 
{
    public static boolean isSafe(char[][] board, int row, int col, int digit)
    {
        // Step 1 : Same Row
        for(int j = 0; j <= 8; j++)
        {
            if(board[row][j] == (char)(digit + '0'))
            {
                return false;
            }
        }

        // Step 2 : Same Column
        for(int i = 0; i <= 8; i++)
        {
            if(board[i][col] == (char)(digit + '0'))
            {
                return false;
            }    
        }

        // Step 3 : Same Grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for(int i = sr; i < sr + 3; i++)
        {
            for(int j = sc; j < sc + 3; j++)
            {
                if(board[i][j] == (char)(digit + '0'))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(char[][] board, int row, int col)
    {
        // Step 1 : Base-Case
        if(row == 9)
        {
            return true;
        }

        // Step 2 : Increments
        int nextRow = row;
        int nextCol = col + 1;

        if(col + 1 == 9)
        {
            nextRow += 1;
            nextCol = 0;
        }

        // Step 3 : Corner Case
        if(board[row][col] != '.')
        {
            return sudokuSolver(board, nextRow, nextCol);
        }

        for(int i = 1; i <= 9; i++)
        {
            if(isSafe(board, row, col, i))
            {
                // Step 4 : Kaam
                board[row][col] = (char)(i + '0');

                // Step 5 : Inner Function Call
                if(sudokuSolver(board, nextRow, nextCol))
                {
                    return true;
                }

                // Step 6 : Backtrack Step
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) 
    {
        if(sudokuSolver(board, 0, 0))    
        {
            System.out.println("Solution Exists");
        }   
        else
        {
            System.out.println("No Solution Exists");
        }
    }
}