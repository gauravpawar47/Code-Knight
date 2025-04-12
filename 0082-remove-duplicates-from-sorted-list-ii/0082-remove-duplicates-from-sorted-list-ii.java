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
    public ListNode deleteDuplicates(ListNode head) 
    {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        dummy.next = head;
        while(head != null)
        {
            if(head.next != null && head.val == head.next.val)
            {
                int duplicate = head.val;
                while(head != null && duplicate == head.val)
                {
                    head = head.next;
                }

                prev.next = head;
            }
            else
            {
                prev = prev.next;
                head = head.next;
            }
        }

        return dummy.next;
    }
}