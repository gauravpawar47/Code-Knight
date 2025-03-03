class Solution 
{
    public int numberOfBeams(String[] bank) 
    {
        ArrayList<Integer> beams = new ArrayList<>();
        int beamCount = 0;

        for(int i = 0; i < bank.length; i++)
        {
            String curr = bank[i];
            for(int j = 0; j < bank[i].length(); j++)
            {
                if(curr.charAt(j) == '1')
                {
                    beamCount++;
                }
            }
            
            if(beamCount > 0)
            {
                beams.add(beamCount);
            }
            beamCount = 0;
        }

        int total = 0;
        for(int i = 1; i < beams.size(); i++)
        {
            int beam = beams.get(i);
            while(beam > 0)
            {
                total += beams.get(i - 1);
                beam--;       
            }
        }

        return total;
    }
}