class Solution 
{
    public String reverseWords(String s) 
    {
        String result = " ";
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++)
        {
            StringBuilder sb = new StringBuilder(str[i]);
            result += sb.reverse().toString() +" ";
        }

        return result.substring(1, result.length() - 1);
    }
}