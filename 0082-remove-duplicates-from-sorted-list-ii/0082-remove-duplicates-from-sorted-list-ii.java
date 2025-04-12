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
        ListNode T = head;
        ArrayList<Integer> list = new ArrayList<>();

        while(T != null)
        {
            list.add(T.val);
            T = T.next;
        }

        ArrayList<Integer> unique = new ArrayList<>();
        int i = 0;
        while(i < list.size())
        {
            int count = 1;
            while(i + count < list.size() && list.get(i).equals(list.get(i + count)))
            {
                count++;
            }

            if(count == 1)
            {
                unique.add(list.get(i));
            }

            i += count;
        }

        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        for(i = 0; i < unique.size(); i++)
        {
            temp.next = new ListNode(unique.get(i));
            temp = temp.next;
        }

        return dummy.next;
    }
}