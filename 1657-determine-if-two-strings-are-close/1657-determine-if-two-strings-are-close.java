class Solution 
{
    public boolean closeStrings(String word1, String word2) 
    {
        int n1 = word1.length();    
        int n2 = word2.length();    

        if(n1 != n2)
        {
            return false;    
        }

        int[] freq1 = new int[26];
        for(int i = 0; i < n1; i++)
        {
            freq1[word1.charAt(i) - 'a']++;
        }
        
        int[] freq2 = new int[26];
        for(int i = 0; i < n2; i++)
        {
            freq2[word2.charAt(i) - 'a']++;
        }

        if(n1 == n2)
        {
            for(int i = 0; i < 26; i++)
            {
                if(freq1[i] >= freq2[i] || freq2[i] >= freq1[i])
                {
                    return true;
                }
            }
        }

        return false;


    }
}