class Solution
{
    public int numTilePossibilities(String tiles)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tiles.length(); i++)
        {
            map.put(tiles.charAt(i), map.getOrDefault(tiles.charAt(i), 0) + 1);
        }    

        return backtrack(map);
    }

    public int backtrack(HashMap<Character, Integer> map)
    {
        int count = 0;
        for(char c : map.keySet())
        {
            if(map.get(c) > 0)
            {
                map.put(c, map.get(c) - 1);
                count += 1 + backtrack(map);
                map.put(c, map.get(c) + 1);
            }
        }

        return count;
    }
}