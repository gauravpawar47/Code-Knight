class Solution 
{
    public String reverseWords(String s) 
    {
        s = s.trim();

        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == ' ')
            {
                if(sb.length() > 0)
                {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
            else
            {
                sb.append(c);
            }
        }

        if(sb.length() > 0)
        {
            list.add(sb.toString());
        }
        
        sb.setLength(0);

        for(int i = list.size() - 1; i >= 0; i--)
        {
            sb.append(list.get(i));
            if(i != 0)
            {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}