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
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null)
        {
            list.add(temp.val);
            temp = temp.next;
        }

        for(int i = 0; i + k <= list.size(); i += k)
        {
            swap(list, i, i + k - 1);
        }

        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;

        for(int i : list)
        {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        return newHead.next;
    }

    public void swap(ArrayList<Integer> list, int start, int end)
    {
        while(start < end)
        {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }
}