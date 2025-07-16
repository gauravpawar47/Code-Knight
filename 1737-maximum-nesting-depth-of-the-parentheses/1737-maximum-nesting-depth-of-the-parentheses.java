class Solution 
{
    public int maxDepth(String s) 
    {
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                stack.push(c);  
            }
            else if(c == ')')
            {
                maxLength = Math.max(maxLength, stack.size());
                stack.pop();
            }
        }     

        return maxLength;
    }
}