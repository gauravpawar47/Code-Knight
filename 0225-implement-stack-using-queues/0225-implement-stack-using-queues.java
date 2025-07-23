class MyStack 
{
    Queue<Integer> queue;
    Queue<Integer> helper;

    public MyStack() 
    {
        queue = new LinkedList<>();    
        helper = new LinkedList<>();    
    }
    
    public void push(int x) 
    {
        helper.add(x);
        while(!queue.isEmpty())    
        {
            helper.add(queue.remove());
        }

        Queue<Integer> temp = queue;
        queue = helper;
        helper = temp;
    }
    
    public int pop() 
    {
        return empty() ? -1 : queue.remove();
    }
    
    public int top() 
    {
        return empty() ? -1 : queue.peek();    
    }
    
    public boolean empty() 
    {
        return queue.isEmpty();    
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