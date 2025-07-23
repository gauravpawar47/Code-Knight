class MyStack 
{
    Queue<Integer> q;
    Queue<Integer> h;
    public MyStack() 
    {
        q = new LinkedList<>();
        h = new LinkedList<>();
    }
    
    public void push(int x) 
    {
        h.add(x);
        while(!q.isEmpty())
        {
            h.add(q.remove());    
        }

        Queue<Integer> t = q;
        q = h;
        h = t;
    }
    
    public int pop() 
    {
        return empty() ? -1 : q.remove();
    }
    
    public int top() 
    {
        return empty() ? -1 : q.peek();
    }
    
    public boolean empty() 
    {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */