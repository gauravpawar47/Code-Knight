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
    public ListNode oddEvenList(ListNode head) 
    {
        ListNode oddTemp = null;
        ListNode evenTemp = null;

        ListNode oddHead = null;
        ListNode evenHead = null;

        ListNode temp = head;
        int index = 1;
        while(temp != null)
        {
            if(index % 2 == 0)
            {
                if(evenHead == null)
                {
                    evenTemp = new ListNode(temp.val);
                    evenHead = evenTemp;
                }
                else
                {
                    evenTemp.next = new ListNode(temp.val);
                    evenTemp = evenTemp.next;
                }
            }
            else
            {
                if(oddHead == null)
                {
                    oddTemp = new ListNode(temp.val);
                    oddHead = oddTemp;
                }
                else
                {
                    oddTemp.next = new ListNode(temp.val);
                    oddTemp = oddTemp.next;
                }
            }

            temp = temp.next;
            index++;
        }

        if(oddTemp != null)
        {
            oddTemp.next = evenHead;
        }

        return oddHead;
    }
}