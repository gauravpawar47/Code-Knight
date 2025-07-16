class Solution 
{
    public String reverseWords(String s) 
    {
        s = s.trim();
        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == ' ')
            {
                if(sb.length() > 0)
                {
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            }
            else
            {
                sb.append(c);
            }
        }

        stack.push(sb.toString());
        sb = new StringBuilder();
        
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}