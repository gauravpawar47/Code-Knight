class Solution 
{
    public int longestValidParentheses(String s) 
    {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] valid = new int[n];
    
        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                stack.push(i);
            }
            else if(!stack.isEmpty())
            {
                int idx = stack.pop();
                valid[idx] = 1;
                valid[i] = 1;

            }
        }

        int maxLen = 0;
        int currLen = 0;
        for(int v : valid)
        {
            if(v == 1)
            {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }
            else
            {
                currLen = 0;
            }
        }

        return maxLen;
    }
}