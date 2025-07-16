class Solution 
{
    public String removeOuterParentheses(String s) 
    {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        
        int prev = 1;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                stack.push(c);    
            }
            else
            {
                stack.pop();
                if(stack.isEmpty())
                {
                    list.add(new String(s.substring(prev, i)));
                    prev = i + 2;
                }
            }
        }    

        StringBuilder sb = new StringBuilder();
        for(String str : list)
        {
            sb.append(str);
        }

        return sb.toString();
    }
}