class Solution
{
    public boolean areAlmostEqual(String s1, String s2)
    {
        if(s1.equals(s2))
        {
            return true;
        }
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        ArrayList<Integer> misMatch = new ArrayList<>();
 
        for(int i = 0; i < s1.length(); i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        
            if(c1 != c2)
            {
                misMatch.add(i);
                if(misMatch.size() > 2)
                {
                    return false;
                }
            }
        }

        if(!map1.equals(map2))
        {
            return false;
        }

        return misMatch.size() == 2 && s1.charAt(misMatch.get(0)) == s2.charAt(misMatch.get(1)) && s1.charAt(misMatch.get(1)) == s2.charAt(misMatch.get(0)); 
    }
}