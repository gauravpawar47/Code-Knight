class Solution 
{
    public boolean isValid(String st) 
    {
        Stack<Character> s = new Stack<>();
        if(st.length() == 1)
        {
            return false;
        }
     
        for(char c : st.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
            {
                s.push(c);
            }
            else if(!s.isEmpty() && 
                        (
                            (c == ')' && s.peek() == '(') || 
                            (c == ']' && s.peek() == '[') || 
                            (c == '}' && s.peek() == '{')
                        )
                    )
            {
                s.pop();
            }
            else
            {
                return false;
            }
        }

        return s.isEmpty();
    }
}