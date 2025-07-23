class MyStack 
{
    ArrayList<Integer> list;
    int rear;

    public MyStack() 
    {
        list = new ArrayList<>();
        rear = 0;
    }
    
    public void push(int x) 
    {
        list.add(rear, x);
    }
    
    public int pop() 
    {
        if(empty())
        {
            return -1;
        }

        return list.remove(rear);
    }
    
    public int top() 
    {
        return list.get(rear);
    }
    
    public boolean empty() 
    {
        return list.isEmpty();
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