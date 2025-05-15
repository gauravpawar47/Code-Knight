class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : t.toCharArray())
        {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        return map1.equals(map2) && t.length() == s.length();
    }
}