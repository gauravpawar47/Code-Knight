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
    public int pairSum(ListNode head) 
    {
        // Step 1 : Find the Middle Using Slow and Fast Pointer
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2 : Reverse the 2nd Half of Linked List
        ListNode secondHalf = reverseList(slow);

        // Step 3 : Traverse both Halves and find the next Twin Sum
        ListNode firstHalf = head;
        int maxTwinSum = 0;

        while(secondHalf != null)
        {
            int twinSum = firstHalf.val + secondHalf.val;
            maxTwinSum = Math.max(maxTwinSum, twinSum);

            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }

        return maxTwinSum;
    }

    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        while(head != null)
        {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;            
        }

        return prev;
    }
}