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
    public ListNode swapNodes(ListNode head, int k) 
    {
        int size = 0;
        ListNode temp = head;

        while(temp != null)
        {
            size++;
            temp = temp.next;
        }

        ListNode A = head;    
        for(int i = 1; i <= k; i++)
        {
            if(i == k)
            {
                break;
            }
            
            A = A.next;
        }

        ListNode B = head;
        for(int i = 1; i <= size - k + 1; i++)
        {
            if(i == size - k + 1)
            {
                break;
            }

            B = B.next;
        }

        int data = A.val;
        A.val = B.val;
        B.val = data; 

        return head;
    }
}