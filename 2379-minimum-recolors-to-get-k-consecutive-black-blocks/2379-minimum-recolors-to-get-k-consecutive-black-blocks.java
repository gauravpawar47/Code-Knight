class Solution
{ 
    public int minimumRecolors(String blocks, int k) 
    {
        int totOp = Integer.MAX_VALUE;
        int n = blocks.length();
        for(int i = 0; i <= n - k; i++)
        {
            int currOp = 0;
            int j = i;
            while(j < i + k)
            {
                if(blocks.charAt(j) == 'W')
                {
                    currOp++;
                }
                j++;   
            }

            totOp = Math.min(currOp, totOp);
        }

        return totOp;
    }
}