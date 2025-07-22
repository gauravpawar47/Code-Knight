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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k == 0)
        {
            return head;
        }

        int size = 0;
        ListNode temp = head;

        while(temp != null)
        {
            size++;
            temp = temp.next;
        }

        k = k % size;
        if(k == 0)
        {
            return head;
        }

        int n = size - k;
        ListNode prev = null;
        temp = head;

        while(n > 0)
        {
            prev = temp;
            temp = temp.next;
            n--;
        }

        prev.next = null;
        ListNode newHead = temp;
        ListNode curr = newHead;

        while(curr.next != null)
        {
            curr = curr.next;
        }

        curr.next = head;
        return newHead;
    }
}