class Solution
{
    public static int minOperations(int[] nums, int k)
    {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        // Add all numbers to minHeap
        for (int num : nums)
        {
            minHeap.add((long) num);
        }

        int operations = 0;
        
        // Continue operations until all elements are >= k
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            long x = minHeap.poll();
            long y = minHeap.poll();
            long newVal = x * 2 + y;

            minHeap.add(newVal);
            operations++;
        }

        return minHeap.peek() >= k ? operations : -1;
    }

    public static void main(String[] args) {
        int[] nums = {999999999, 999999999, 999999999};
        int k = 1000000000;
        System.out.println(minOperations(nums, k)); // Expected output: 2
    }
}
