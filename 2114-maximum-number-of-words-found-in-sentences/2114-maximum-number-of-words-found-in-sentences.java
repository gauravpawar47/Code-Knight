class Solution 
{
    public int mostWordsFound(String[] sentences) 
    {
        int maxWords = 0;
        for(int i = 0; i < sentences.length; i++)
        {
            int currCount = 0;
            String str = sentences[i];
            for(int j = 0; j < str.length(); j++)
            {
                if(str.charAt(j) == ' ')
                {
                    currCount++;
                }
            }

            maxWords = Math.max(currCount + 1, maxWords);
        }     

        return maxWords;
    }
}