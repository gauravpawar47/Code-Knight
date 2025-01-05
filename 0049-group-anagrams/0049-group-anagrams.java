class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s : strs)
        {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String sorted = new String(str);

            if(!map.containsKey(sorted))
            {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(s);
        }       

        result.addAll(map.values());
        return result;
    }
}