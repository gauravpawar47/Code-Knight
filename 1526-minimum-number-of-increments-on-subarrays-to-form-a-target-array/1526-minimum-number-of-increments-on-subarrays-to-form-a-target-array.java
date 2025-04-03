class Solution 
{
    public int minNumberOperations(int[] target) 
    {
        Stack<Integer> stack = new Stack<>();
        int op = 0;

        for(int i = 0; i < target.length; i++)
        {
            if(stack.isEmpty() || target[i] > stack.peek())
            {
                op += target[i] - (stack.isEmpty() ? 0 : stack.peek());
            }

            while(!stack.isEmpty() && stack.peek() > target[i])
            {
                stack.pop();
            }

            stack.push(target[i]);
        }

        return op;
    }
}