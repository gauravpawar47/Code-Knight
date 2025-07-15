class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        if(s.length() != t.length())
        {
            return false;
        }

        int[] freq1 = new int[26];    
        for(char c : s.toCharArray())
        {
            freq1[c - 'a']++;
        }

        int[] freq2 = new int[26];    
        for(char c : t.toCharArray())
        {
            freq2[c - 'a']++;
        }

        for(int i = 0; i < 26; i++)
        {
            if(freq1[i] != freq2[i])
            {
                return false;
            }
        }

        return true;
    }
}