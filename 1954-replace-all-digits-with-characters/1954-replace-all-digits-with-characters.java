class Solution 
{
    public String replaceDigits(String s) 
    {
        StringBuilder sb = new StringBuilder("");
        char[] str = s.toCharArray();

        for(int i = 0; i < str.length; i++)
        {
            char curr = str[i];
            if(Character.isDigit(curr))
            {
                char prev = str[i - 1];
                sb.append((char) (prev + (curr - '0')));
            }
            else
            {
                sb.append(curr);
            }
        }

        return sb.toString();
    }
}