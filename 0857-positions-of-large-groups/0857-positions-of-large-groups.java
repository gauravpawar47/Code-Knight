class Solution 
{
    public List<List<Integer>> largeGroupPositions(String s) 
    {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) 
        {
            int count = getCount(s, i);
            if (count >= 3) 
            {
                int start = i;
                int end = i + count - 1;
            
                result.add(Arrays.asList(start, end));
                i += count - 1; // Skip processed characters
            }
        }

        return result;
    }

    public int getCount(String s, int index) 
    {
        char c = s.charAt(index);
        int count = 1;
        int i = index + 1;
    
        while (i < s.length() && s.charAt(i) == c) 
        {
            count++;
            i++;
        }
        
        return count;
    }
}