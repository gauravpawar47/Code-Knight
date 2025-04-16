class Solution 
{
    public static boolean isSafe(char[][] board, int row, int col)
    {
        // Step 1 : Vertically Up
        for(int i = row - 1; i >= 0; i--)
        {
            if(board[i][col] == 'Q')
            {
                return false;
            }
        }

        // Step 2 : Vertically Diagonally Left
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }

        // Step 3 : Vertically Diagonally Right
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char[][] board, int row, List<List<String>> result)
    {
        // Step 1 : Base-Case
        if(row == board.length)
        {
            result.add(constructSolution(board));
            return;
        }

        // Step 2 : Kaam
        for(int j = 0; j < board.length; j++)
        {
            if(isSafe(board, row, j))
            {
                board[row][j] = 'Q';

                // Step 3 : Inner Function Call
                nQueens(board, row + 1, result);

                // Step 4 : Backtrack Step
                board[row][j] = '.';
            }
        }
    }

    public static List<String> constructSolution(char[][] board)
    {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++)
            {
                sb.append(board[i][j]);
            }   
            result.add(sb.toString());
        }

        return result;
    }

    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] current : board)
        {
            Arrays.fill(current, '.');
        }

        nQueens(board, 0, result);
        return result;
    }
}