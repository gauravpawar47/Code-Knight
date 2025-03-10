class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), i);
        }    

        List<Integer> list = new ArrayList<>();
        int lastIdx = 0;
        int pIdx = 0;

        for(int i = 0; i < s.length(); i++)
        {
            lastIdx = Math.max(lastIdx, map.get(s.charAt(i)));
            if(i == lastIdx)
            {
                list.add(i - pIdx + 1);
                pIdx = i + 1;
            }
        }

        return list;
    }
}