class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return true;
        }

        int size = 0;
        ListNode temp = head;
        while(temp != null)
        {
            temp = temp.next;
            size++;
        }

        int mid = size / 2;
        Stack<Integer> stack = new Stack<>();

        int i = 1; 
        ListNode left = head;
        ListNode right = head;
        while(i <= mid)
        {
            stack.push(left.val);
            left = left.next;
            right = right.next;
            i++;
        }

        // ✅ Skip the middle node for odd-length lists
        if(size % 2 != 0)
        {
            right = right.next;
        }

        while(right != null)
        {
            if(stack.isEmpty() || stack.pop() != right.val)
            {
                return false;
            }
            right = right.next;
        }

        return true;
    }
}
