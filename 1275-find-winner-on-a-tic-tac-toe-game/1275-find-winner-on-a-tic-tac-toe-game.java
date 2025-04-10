class Solution 
{
    public String tictactoe(int[][] moves) 
    {
        char[][] board = new char[3][3];

        for(int i = 0; i < moves.length; i++)
        {
            int x = moves[i][0];
            int y = moves[i][1];
            board[x][y] = (i % 2 == 0) ? 'X' : 'O';
        }

        // 1st Column
        char curr1 = board[0][0];
        int trace1 = 0;
        for(int i = 0; i < 3; i++)
        {
            if(curr1 != 0 && curr1 == board[i][0])
            {
                trace1++;
            }
        }

        if(trace1 == 3)
        {
            return curr1 == 'X' ? "A" : "B";
        } 

        // 2nd Column
        char curr2 = board[0][1];
        int trace2 = 0;
        for(int i = 0; i < 3; i++)
        {
            if(curr2 != 0 && curr2 == board[i][1])
            {
                trace2++;
            }
        }
        
        if(trace2 == 3)
        {
            return curr2 == 'X' ? "A" : "B";
        } 

        // 3rd Column
        char curr3 = board[0][2];
        int trace3 = 0;
        for(int i = 0; i < 3; i++)
        {
            if(curr3 != 0 && curr3 == board[i][2])
            {
                trace3++;
            }
        }
        
        if(trace3 == 3)
        {
            return curr3 == 'X' ? "A" : "B";
        } 

        // 1st Row
        char curr4 = board[0][0];
        int trace4 = 0;
        for(int j = 0; j < 3; j++)
        {
            if(curr4 != 0 && curr4 == board[0][j])
            {
                trace4++;
            }
        }
        
        if(trace4 == 3)
        {
            return curr4 == 'X' ? "A" : "B";
        } 

        // 2nd Row
        char curr5 = board[1][0];
        int trace5 = 0;
        for(int j = 0; j < 3; j++)
        {
            if(curr5 != 0 && curr5 == board[1][j])
            {
                trace5++;
            }
        }
        
        if(trace5 == 3)
        {
            return curr5 == 'X' ? "A" : "B";
        } 

        // 3rd Row
        char curr6 = board[2][0];
        int trace6 = 0;
        for(int j = 0; j < 3; j++)
        {
            if(curr6 != 0 && curr6 == board[2][j])
            {
                trace6++;
            }
        }
        
        if(trace6 == 3)
        {
            return curr6 == 'X' ? "A" : "B";
        } 

        // Diagonal: Top-Left to Bottom-Right
        char curr7 = board[0][0];
        int trace7 = 0;
        for(int j = 0; j < 3; j++)
        {
            if(curr7 != 0 && curr7 == board[j][j])
            {
                trace7++;
            }
        }
        
        if(trace7 == 3)
        {
            return curr7 == 'X' ? "A" : "B";
        } 

        // Diagonal: Top-Right to Bottom-Left
        char curr8 = board[0][2];
        int trace8 = 0;
        int i = 0;
        for(int j = 2; j >= 0; j--)
        {
            if(curr8 != 0 && curr8 == board[i][j])
            {
                trace8++;
            }
            i++;
        }
        
        if(trace8 == 3)
        {
            return curr8 == 'X' ? "A" : "B";
        } 

        // Pending or Draw
        return moves.length < 9 ? "Pending" : "Draw";
    }
}