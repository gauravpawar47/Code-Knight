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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode node = head;
        int count = 0;

        // Step 1: Check if we have at least k nodes
        while (node != null && count < k) 
        {
            node = node.next;
            count++;
        }

        if (count < k)
        {
            return head; // Not enough nodes to reverse
        } 

        // Step 2: Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int i = 0;

        while (i < k) 
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // Step 3: head is now the tail after reversal
        head.next = reverseKGroup(curr, k);

        return prev; // prev is the new head after reversing
    }
}