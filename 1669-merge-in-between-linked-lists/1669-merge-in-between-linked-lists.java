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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode aHead = list1;
        for(int i = 0; i < a - 1; i++) {
            aHead = aHead.next;
        }

        ListNode bHead = aHead;
        for(int i = 0; i < b - a + 2; i++) {
            bHead = bHead.next;
        }

        aHead.next = list2;

        ListNode temp = list2;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = bHead;

        return list1;
    }
}