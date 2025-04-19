class Solution 
{
    int count = 0;
    public boolean isSafe(char[][] board, int row, int col)
    {
        // Step 1 : Vertically Up
        for(int i = row - 1; i >= 0; i--)
        {
            if(board[i][col] == 'Q')
            {
                return false;
            }
        }

        // Step 2 : Vertically Diagonal Left
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }

        // Step 3 : Vertically Diagonal Right 
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }

        return true;
    }

    public void nQueen(char[][] board, int row)
    {
        // Step 1 : Base-Case
        if(row == board.length)
        {
            count++;
            return;
        }

        // Step 2 : Kaam
        for(int j = 0; j < board.length; j++)
        {
            if(isSafe(board, row, j))
            {
                board[row][j] = 'Q';

                // Step 3 : Inner Function Call
                nQueen(board, row + 1);

                // Step 4 : Backtrack
                board[row][j] = '.';
            }
        }
    }

    public int totalNQueens(int n) 
    {
        char[][] board = new char[n][n];
        for(char[] row : board)
        {
            Arrays.fill(row, '.');
        }

        nQueen(board, 0);
        return count;
    }
}