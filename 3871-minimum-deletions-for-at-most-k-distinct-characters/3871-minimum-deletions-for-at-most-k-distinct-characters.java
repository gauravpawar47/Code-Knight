class Solution 
{
    public int minDeletion(String s, int k) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        int distinctCount = map.size();
        if (distinctCount <= k) 
        {
            return 0;
        }

        List<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies); // sort by frequency ascending

        int removals = 0;
        int toRemove = distinctCount - k;

        for (int i = 0; i < frequencies.size() && toRemove > 0; i++) 
        {
            removals += frequencies.get(i);
            toRemove--;
        }

        return removals;
    }
}