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
    public int getDecimalValue(ListNode head) 
    {
        // Step 1: Initialize a variable
        int dec = 0;

        // Step 2: Traverse the linked list
        ListNode temp = head;
        while (temp != null) 
        {
            // Left shift dec by 1 and OR with current node value
            dec = (dec << 1) | temp.val;

            // Step 3: Move to the next node
            temp = temp.next;
        }

        // Step 4: Return the result
        return dec;
    }
}