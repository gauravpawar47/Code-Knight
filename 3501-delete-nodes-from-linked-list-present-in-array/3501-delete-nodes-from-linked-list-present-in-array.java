class Solution 
{
    public ListNode modifiedList(int[] nums, ListNode head) 
    {
        // Step 1: Store nums in a HashSet for O(1) lookup
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) 
        {
            numSet.add(num);
        }

        // Step 2: Create a dummy node pointing to head to handle head deletions
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 3: Use a pointer 'curr' to traverse the list
        ListNode curr = dummy;

        // Step 4: Traverse and remove nodes whose values exist in numSet
        while (curr.next != null) 
        {
            if (numSet.contains(curr.next.val)) 
            {
                // Delete node by skipping it
                curr.next = curr.next.next;
            } 
            else 
            {
                // Move to next node
                curr = curr.next;
            }
        }

        // Step 5: Return modified list (skipping dummy node)
        return dummy.next;
    }
}