class Solution
{
    public int calculate(String s)
    {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int num = 0;
        char prevOp = '+';

        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
         
            if(Character.isDigit(c))
            {
                num = num * 10 + (c - '0');
            }

            if((!Character.isDigit(c) && c != ' ') || i == n - 1)
            {
                switch(prevOp)
                {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                }

                prevOp = c;
                num = 0;
            }
        }

        int result = 0;
        for(int val : stack)
        {
            result += val;
        }

        return result;
    }
}