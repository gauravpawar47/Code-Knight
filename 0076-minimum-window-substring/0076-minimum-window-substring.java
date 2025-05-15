class Solution
{
    public String minWindow(String s, String t)
    {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
        {
            return new String();
        }
           
        int[] map = new int[128];
        int count = t.length();
        
        int start = 0;
        int end = 0;
        
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        for(char ch : t.toCharArray())
        {
            map[ch]++;
        }

        char[] chS = s.toCharArray();
        while(end < chS.length)
        {
            if(map[chS[end++]]-- > 0)
            {
                count--;
            }

            while(count == 0)
            {
                if(end - start < minLen)
                {
                    startIdx = start;
                    minLen = end - start;
                }

                if(map[chS[start++]]++ == 0)
                {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIdx, minLen);
    }
}