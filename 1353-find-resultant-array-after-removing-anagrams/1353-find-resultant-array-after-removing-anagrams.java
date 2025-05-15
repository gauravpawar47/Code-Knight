class Solution 
{
    public boolean isAnagram(String s, String t)
    {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        Arrays.sort(S);
        Arrays.sort(T);

        return Arrays.equals(S, T);
    }

    public List<String> removeAnagrams(String[] words) 
    {
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);

        for(int i = 1; i < words.length; i++)
        {
            if(!isAnagram(words[i], list.get(list.size() - 1)))
            {
                list.add(words[i]);
            }
        }

        return list;
    }
}