class Solution 
{
    public class Pair
    {
        char ch;
        int count;

        Pair(char ch, int count)
        {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) 
    {
        Stack<Pair> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek().ch == c)
            {
                stack.peek().count++;
            }
            else
            {
                stack.push(new Pair(c, 1));
            }

            if(stack.peek().count == k)
            {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Pair p : stack)
        {
            sb.append(String.valueOf(p.ch).repeat(p.count));
        }

        return sb.toString();
    }
}