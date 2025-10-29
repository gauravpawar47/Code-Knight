class Solution 
{
    public int maximumNumberOfStringPairs(String[] words) 
    {
        int count = 0;
        for(int i = 0; i < words.length; i++)
        {
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            words[i] = new String(ch);
        } 

        Arrays.sort(words);
        for(int i = 0; i < words.length - 1; i++)
        {
            if(words[i].equals(words[i + 1]))
            {
                count++;
            }
        }

        return count;   
    }
}