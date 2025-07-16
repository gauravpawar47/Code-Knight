class Solution 
{
    public int beautySum(String s) 
    {
        int totalBeauty = 0;

        for(int i = 0; i < s.length(); i++)
        {
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++)
            {
                char c = s.charAt(j);
                freq[c - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for(int f : freq)
                {
                    if(f > 0)
                    {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                totalBeauty += maxFreq - minFreq;
            }
        }    

        return totalBeauty;
    }
}