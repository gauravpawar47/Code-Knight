class Solution 
{
    public int longestPalindrome(String[] words) 
    {
        HashMap<String, Integer> map = new HashMap<>();
        int length = 0;

        for(String word : words)
        {
            String rev = new StringBuilder(word).reverse().toString();
            if(map.containsKey(rev) && map.get(rev) > 0)
            {
                length += 4;
                map.put(rev, map.get(rev) - 1);
            }
            else
            {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }    

        boolean hasMiddle = false;
        for(String key : map.keySet())
        {
            if(key.charAt(0) == key.charAt(1) && map.get(key) > 0)
            {
                hasMiddle = true;
                break;
            }
        }

        if(hasMiddle)
        {
            length += 2;
        }

        return length;
    }
}