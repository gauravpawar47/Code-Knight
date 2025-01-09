class MinStack
{
    Stack<Integer> stack;
    Stack<Integer> minStack;  // Stack to keep track of the minimum value

    public MinStack()
    {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) 
    {
        stack.push(val);
    
        // Push the minimum value onto the minStack
        if (minStack.isEmpty() || val <= minStack.peek())
        {
            minStack.push(val);
        }
        else 
        {
            minStack.push(minStack.peek());
        }
    }

    public void pop() 
    {
        stack.pop();
        minStack.pop();
    }

    public int top() 
    {
        return stack.peek();
    }

    public int getMin() 
    {
        return minStack.peek();  // The top of minStack always has the minimum value
    }
}