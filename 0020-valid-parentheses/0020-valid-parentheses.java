class Solution
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                if((c == ')' || c == ']' || c == '}') && stack.isEmpty())
                {
                    return false;
                }
                else if(c == ')' && stack.peek() == '(')
                {
                    stack.pop();
                }
                else if(c == ']' && stack.peek() == '[')
                {
                    stack.pop();
                }
                else if(c == '}' && stack.peek() == '{')
                {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}