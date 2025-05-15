class Solution 
{
    public int numberOfSubstrings(String s, int k) 
    {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int found = -1;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++)
            {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.get(ch) >= k)
                {
                    found = j;
                    break;
                }
            }

            if(found != -1)
            {
                count += s.length() - found;
            }
        }    

        return count;
    }
}