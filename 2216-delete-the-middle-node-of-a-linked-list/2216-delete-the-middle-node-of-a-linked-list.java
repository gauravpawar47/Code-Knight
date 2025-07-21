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
    public ListNode deleteMiddle(ListNode head) 
    {
        int size = 0;
        ListNode temp = head;
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }

        int mid = size / 2;
        int i = 0;

        if(size == 1 || size == 0)
        {
            return null;
        }
        
        if(size  == mid + 1)
        {
            head.next = null;
            return head;
        }

        temp = head;
        while(i < mid - 1)
        {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        return head;
    }
}