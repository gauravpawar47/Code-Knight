class Solution 
{
    public String[] findWords(String[] words) 
    {
        String[] board = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        ArrayList<Integer> idx = new ArrayList<>(); 

        for(int i = 0; i < words.length; i++)
        {
            String s = words[i];
            int row = -1;
            boolean isMatched = true;

            for(int j = 0; j < s.length(); j++)
            {
                char c = Character.toLowerCase(s.charAt(j));
                if(row == -1)
                {
                    for(int k = 0; k < board.length; k++)
                    {
                        if(board[k].indexOf(c) != -1)
                        {
                            row = k;
                            break;
                        }
                    }
                }

                if(board[row].indexOf(c) == -1)
                {
                    isMatched = false;
                    break;
                }                
            }

            if(isMatched)
            {
                idx.add(i);       
            }
        }

        String[] result = new String[idx.size()];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = words[idx.get(i)];
        }

        return result;
    }
}