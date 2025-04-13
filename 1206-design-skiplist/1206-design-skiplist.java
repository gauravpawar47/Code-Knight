class Skiplist 
{
    static final int MAX_LEVEL = 16;
    static final double P = 0.5;
    
    static class Node 
    {
        int val;
        Node[] forward;

        Node(int val, int level) 
        {
            this.val = val;
            this.forward = new Node[level];
        }
    }

    private final Node head;
    private final Random rand;

    public Skiplist() 
    {
        head = new Node(-1, MAX_LEVEL);
        rand = new Random();
    }

    private int randomLevel() 
    {
        int level = 1;
        while (rand.nextDouble() < P && level < MAX_LEVEL) 
        {
            level++;
        }
        return level;
    }

    public boolean search(int target) 
    {
        Node curr = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) 
        {
            while (curr.forward[i] != null && curr.forward[i].val < target) 
            {
                curr = curr.forward[i];
            }
        }

        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) 
    {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;

        for (int i = MAX_LEVEL - 1; i >= 0; i--) 
        {
            while (curr.forward[i] != null && curr.forward[i].val < num) 
            {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int level = randomLevel();
        Node newNode = new Node(num, level);
        for (int i = 0; i < level; i++) 
        {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) 
    {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;

        for (int i = MAX_LEVEL - 1; i >= 0; i--) 
        {
            while (curr.forward[i] != null && curr.forward[i].val < num) 
            {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];
        if (curr == null || curr.val != num) 
        {
            return false;
        }

        for (int i = 0; i < MAX_LEVEL; i++) 
        {
            if (update[i].forward[i] != curr)
            {
                break;
            } 
            update[i].forward[i] = curr.forward[i];
        }

        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */