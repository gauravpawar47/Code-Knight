class MyQueue
{
    Stack<Integer> stack;
    public MyQueue() 
    {
        stack = new Stack<>();
    }
    
    public void push(int x)
    {
        stack.push(x);
    }
    
    public int pop()
    {
        // Step 1 : Base-Case
        int x = stack.pop();
        if(stack.isEmpty())
        {
            return x;
        }

        // Step 2 : Recursive Call
        int data = pop();

        // Step 3 : Kaam
        stack.push(x);
        return data;
    }
    
    public int peek()
    {
        // Step 1 : Base-Case
        int x = stack.pop();
        if(stack.isEmpty())
        {
            stack.push(x);
            return x;
        }    

        // Step 2 : Recursive Call
        int peek = peek();

        // Step 3 : Kaam
        stack.push(x);
        return peek;
    }
    
    public boolean empty()
    {
        return stack.isEmpty();    
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */