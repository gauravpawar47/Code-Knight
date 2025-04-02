class Solution
{
    public String decodeString(String s)
    {
        Stack<Integer> number = new Stack<>();
        Stack<String> string = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 0;
        
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num = num * 10 + (c - '0');
            }
            else if(c == '[')
            {
                number.push(num);
                string.push(result.toString());

                num = 0;
                result = new StringBuilder();
            }
            else if(c == ']')
            {
                int repeatition = number.pop();
                StringBuilder current = new StringBuilder(string.pop());

                current.append(result.toString().repeat(repeatition));
                result = current;
            }
            else
            {
                result.append(c);
            }
        }

        return result.toString();
    }
}