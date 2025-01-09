class MyStack
{
    int[] queue;
    int rear;
    int maxSize;

    public MyStack()
    {
        rear = -1;
        maxSize = 100;
        queue = new int[maxSize];    
    }
    
    public void push(int x)
    {
        rear++;
        queue[rear] = x;
    }
    
    public int pop()
    {
        if(empty())
        {
            return -1;
        }
        else
        {
            int data = top();
            queue[rear] = 0;
            rear--;

            return data;
        }
    }
    
    public int top()
    {    
        return empty() ? -1 : queue[rear];
    }
    
    public boolean empty()
    {
        return rear == -1;    
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