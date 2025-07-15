class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        if (needle.length() == 0)
        {
            return 0;
        } 

        if(needle.length() > haystack.length())
        {
            return -1;
        }
        
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i <= haystack.length() - needle.length(); i++)
        {
            if(haystack.charAt(i) == needle.charAt(0))
            {
                index.add(i);
            }
        }

        for(int idx : index)
        {
            int count = 0;
            int j = 0;
            for(int i = idx; i < idx + needle.length(); i++)
            {
                if(haystack.charAt(i) != needle.charAt(j))
                {
                    break;
                }
                count++;
                j++;
            }

            if(count == needle.length())
            {
                return idx;
            }
        }

        return -1;
    }
}