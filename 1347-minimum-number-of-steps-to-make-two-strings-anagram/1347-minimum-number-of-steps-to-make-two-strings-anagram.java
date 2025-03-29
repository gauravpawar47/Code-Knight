class Solution 
{
    public int minSteps(String s, String t) 
    {
        int[] s1 = new int[26];    
        int[] t1 = new int[26];    

        int n = s.length();
        for(int i = 0; i < n; i++)
        {
            s1[s.charAt(i) - 'a']++;
            t1[t.charAt(i) - 'a']++;
        }

        int steps = 0;
        for(int i = 0; i < t1.length; i++)
        {
            if(s1[i] > t1[i])
            {
                steps += s1[i] - t1[i]; 
            }            
        }

        return steps;
    }
}