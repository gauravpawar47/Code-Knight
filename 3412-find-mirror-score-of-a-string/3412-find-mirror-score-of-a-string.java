class Solution 
{
    public boolean areMirrors(char a, char b) {
        return (a + b) == ('a' + 'z');
    }

    public long calculateScore(String s)
    {
        long count = 0;
        boolean[] isMarked = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) 
        {
            if (isMarked[i])
            {
                continue; // Skip already paired characters
            }
        
            for (int j = i + 1; j < s.length(); j++) 
            {
                if (isMarked[j]) 
                {
                    continue; // Skip already paired characters
                }
                
                if (areMirrors(s.charAt(i), s.charAt(j))) 
                {
                    count += j - i; // Increment distance between indices
                    isMarked[i] = true;
                    isMarked[j] = true;
                    break; // Break inner loop once a pair is found
                }
            }
        }
        
        return count;
    }
}