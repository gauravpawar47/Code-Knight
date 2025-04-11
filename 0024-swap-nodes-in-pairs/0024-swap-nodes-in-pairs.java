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
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        int size = 0;
        ListNode t = head;
        
        while(t != null)
        {
            size++;
            t = t.next;
        }

        ListNode temp = head;
        for(int i = 0; i < size - 1; i += 2)
        {
            int data = temp.next.val;
            temp.next.val = temp.val;
            temp.val = data;

            temp = temp.next.next;
        }
        
        return head;
    }
}