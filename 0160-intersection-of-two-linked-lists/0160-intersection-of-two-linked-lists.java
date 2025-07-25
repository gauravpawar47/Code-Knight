/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        if(headA == null || headB == null)
        {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2)
        {
            if(p1 != null)
            {
                p1 = p1.next;
            }
            else
            {
                p1 = headA;
            }

            if(p2 != null)
            {
                p2 = p2.next;
            }
            else
            {
                p2 = headB;
            }
        }

        return p1;
    }
}