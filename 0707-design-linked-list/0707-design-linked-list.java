class MyLinkedList
{
    class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public MyLinkedList()
    {
        head = tail = null;
    }

    public int get(int index)
    {
        Node temp = head;
        int i = 0;
        while (temp != null && i < index)
        {
            temp = temp.next;
            i++;
        }
        
        return temp == null ? -1 : temp.data;
    }

    public void addAtHead(int val)
    {
        Node newNode = new Node(val);
        if (head == null)
        {
            head = tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addAtTail(int val)
    {
        Node newNode = new Node(val);
        if (tail == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode; 
        }
    }

    public void addAtIndex(int index, int val)
    {
        if (index < 0) 
        {
            return;
        }
            
        Node newNode = new Node(val);
        if (index == 0)
        {
            addAtHead(val);
            return;
        }
        
        Node temp = head;
        for (int i = 0; i < index - 1 && temp != null; i++)
        {
            temp = temp.next;
        }
        
        if (temp == null)
        {
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        
        if (newNode.next == null)
        {
            tail = newNode;
        }
    }

    public void deleteAtIndex(int index)
    {
        if (index < 0 || head == null)
        {
            return;
        }

        if (index == 0)
        {
            head = head.next;
            if (head == null)
            {
                tail = null;
            }
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1 && temp != null; i++)
        {
            temp = temp.next;
        }
        
        if (temp == null || temp.next == null)
        {
            return;
        } 
            
        temp.next = temp.next.next;
        if (temp.next == null)
        {
            tail = temp;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */