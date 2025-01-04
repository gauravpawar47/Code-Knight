class Solution
{
    public int matchPlayersAndTrainers(int[] players, int[] trainers)
    {
        Arrays.sort(players);    
        Arrays.sort(trainers);

        int count = 0;
        int i = 0;
        while(i < players.length)
        {
            int j = 0;
            while(j < trainers.length)
            {
                if(i < players.length && trainers[j] >= players[i])
                {
                    count++;
                    i++;
                }
                j++;
            }

            if(j == trainers.length)
            {
                break;
            }
            i++;
        }    

        return count;
    }
}