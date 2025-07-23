class MyQueue 
{
    Stack<Integer> s;
    Stack<Integer> h;

    public MyQueue() 
    {
        s = new Stack<>();    
        h = new Stack<>();    
    }
    
    public void push(int x) 
    {
        while(!s.isEmpty())
        {
            h.push(s.pop());
        }

        s.push(x);
        while(!h.isEmpty())
        {
            s.push(h.pop());
        }
    }
    
    public int pop() 
    {
        return empty() ? -1 : s.pop();
    }
    
    public int peek() 
    {
        return empty() ? -1 : s.peek();
    }
    
    public boolean empty() 
    {
        return s.isEmpty();
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