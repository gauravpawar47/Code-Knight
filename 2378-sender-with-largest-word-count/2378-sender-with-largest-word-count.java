class Solution 
{
    public String largestWordCount(String[] messages, String[] senders) 
    {
        int n = messages.length;
        HashMap<String, Integer> map = new HashMap<>();
    
        for(int i = 0; i < n; i++)
        {
            int wordCount = messages[i].split(" ").length;
            map.put(senders[i], map.getOrDefault(senders[i], 0) + wordCount);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if(!a.getValue().equals(b.getValue()))
            {
                return b.getValue().compareTo(a.getValue());
            }
            else
            {
                return b.getKey().compareTo(a.getKey());
            }
        });

        return new String(list.get(0).getKey());
    }
}