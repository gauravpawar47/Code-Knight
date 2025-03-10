class Solution 
{
    public boolean isVowel(char ch) 
    {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public String sortVowels(String s) 
    {
        int count = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            if (isVowel(s.charAt(i))) 
            {
                count++;
            }
        }

        char[] str = new char[count];
        int j = 0;

        for (int i = 0; i < s.length(); i++) 
        {
            if (isVowel(s.charAt(i))) 
            {
                str[j] = s.charAt(i);
                j++;
            }
        }

        Arrays.sort(str);
        j = 0;

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) 
        {
            if (isVowel(sb.charAt(i))) 
            {
                sb.setCharAt(i, str[j]);
                j++;
            }
        }

        return sb.toString();
    }
}