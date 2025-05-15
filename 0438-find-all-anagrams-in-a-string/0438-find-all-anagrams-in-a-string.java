class Solution 
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(s.length() < p.length())
        {
            return list;    
        }    

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        int m = p.length();

        for(int i = 0; i < m; i++)
        {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sCount, pCount))
        {
            list.add(0);
        }

        for(int i = m; i < s.length(); i++)
        {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - m) - 'a']--;

            if(Arrays.equals(sCount, pCount))
            {
                list.add(i - m + 1);
            }
        }

        return list;
    }
}