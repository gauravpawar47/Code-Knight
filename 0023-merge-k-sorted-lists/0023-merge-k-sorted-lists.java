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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i++)
        {
            ListNode temp = lists[i];
            while(temp != null)
            {
                list.add(temp.val);
                temp = temp.next;
            }
        }    

        ListNode result = new ListNode(0);
        ListNode temp = result;

        while(!list.isEmpty())
        {
            temp.next = new ListNode(list.poll());
            temp = temp.next;
        }

        return result.next;
    }
}