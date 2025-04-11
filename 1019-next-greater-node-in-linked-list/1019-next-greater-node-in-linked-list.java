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
    public int[] nextLargerNodes(ListNode head) 
    {
        int size = 0;
        ListNode T = head;
        while (T != null) 
        {
            size++;
            T = T.next;
        }

        // Reverse the linked list
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null) 
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev; // Now head is at the reversed list

        int[] result = new int[size];
        Stack<Integer> st = new Stack<>();

        for (int i = size - 1; i >= 0; i--) 
        {
            // Pop all smaller or equal values
            while (!st.isEmpty() && st.peek() <= head.val) 
            {
                st.pop();
            }

            result[i] = st.isEmpty() ? 0 : st.peek();
            st.push(head.val);
            head = head.next;
        }

        return result;
    }
}