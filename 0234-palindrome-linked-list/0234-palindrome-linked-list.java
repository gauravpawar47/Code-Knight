/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

        int mid = (size / 2);
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

        if(size % 2 == 1)
        {
            right = right.next;
        }

        while(right != null && stack.peek() == right.val)
        {
            stack.pop();
            right = right.next;
        }

        return stack.isEmpty();
    }
}