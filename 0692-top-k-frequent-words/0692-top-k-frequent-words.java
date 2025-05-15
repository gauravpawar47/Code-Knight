class Solution 
{
    public List<String> topKFrequent(String[] words, int k) 
    {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : words)
        {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }   

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if(!a.getValue().equals(b.getValue()))
            {
                return b.getValue().compareTo(a.getValue());
            }
            else
            {
                return a.getKey().compareTo(b.getKey());
            }
        });

        List<String> result = new ArrayList<>();
        for(int i = 0; i < list.size() && k > 0; i++, k--)
        {
            result.add(list.get(i).getKey());
        }

        return result;
    }
}