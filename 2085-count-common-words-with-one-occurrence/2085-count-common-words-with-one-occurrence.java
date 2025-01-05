class Solution
{
    public int countWords(String[] words1, String[] words2) 
    {
        HashMap<String, Integer> m1 = new HashMap<>();
        for(int i = 0; i < words1.length; i++)
        {
            m1.put(words1[i], m1.getOrDefault(words1[i], 0) + 1);
        } 
        
        HashMap<String, Integer> m2 = new HashMap<>();
        for(int i = 0; i < words2.length; i++)
        {
            m2.put(words2[i], m2.getOrDefault(words2[i], 0) + 1);
        } 

        int count = 0;
        for(String word : m1.keySet())
        {
            if(m2.containsKey(word) && m1.get(word) == 1 && m2.get(word) == 1)
            {
                count++;
            }
        }
        
        return count;
    }
}