class MyCircularQueue
{
    int[] queue;
    int maxSize;
    int front;
    int rear;

    public MyCircularQueue(int k)
    {
        maxSize = k;
        queue = new int[maxSize];
        front = rear = -1;    
    }
    
    public boolean enQueue(int value)
    {
        if(isFull())
        {
            return false;
        }

        if(isEmpty())
        {
            front = rear = 0;
        }
        else
        {
            rear = (rear + 1) % maxSize; 
        }

        queue[rear] = value;
        return true;
    }
    
    public boolean deQueue()
    {
        if(isEmpty())
        {
            return false;
        }    
        else
        {
            if(front == rear)
            {
                front = rear = -1;
            }
            else
            {
                front = (front + 1) % maxSize;
            }
            return true;
        }
    }
    
    public int Front()
    {
        if(isEmpty())
        {
            return -1;
        }   
        return queue[front];
    }
    
    public int Rear()
    {
        if(isEmpty())
        {
            return -1;
        }
        return queue[rear];
    }
    
    public boolean isEmpty()
    {
        return front == -1 && rear == -1;    
    }
    
    public boolean isFull()
    {
        return front == (rear + 1) % maxSize;       
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */