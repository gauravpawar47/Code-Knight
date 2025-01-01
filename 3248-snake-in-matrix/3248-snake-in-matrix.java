class Solution 
{
    public int finalPositionOfSnake(int n, List<String> commands)
    {
        int i = 0;
        int j = 0;
        int k = 0;

        while(k < commands.size())
        {
            String command = commands.get(k);
            if(command.equals("UP"))
            {
                i--;
            }
            else if(command.equals("DOWN"))
            {
                i++;
            }
            else if(command.equals("LEFT"))
            {
                j--;
            }
            else if(command.equals("RIGHT"))
            {
                j++;
            }

            k++;
        }    

        return (i * n) + j;
    }
}