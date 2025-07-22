public class Solution 
{
    public int maximumUniqueSubarray(int[] nums) 
    {
        int n = nums.length;

        // Step 1: Create a Prefix Sum Array
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i)
        {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Step 2: Track Last Seen Indices of Elements
        int[] lastSeen = new int[10001];  // store index + 1

        // Step 3: Use the Sliding Window Technique
        int left = 0, maxSum = 0;
        for (int right = 1; right <= n; ++right) 
        {
            int val = nums[right - 1];

            // If duplicate found, move left pointer
            left = Math.max(left, lastSeen[val]);

            // Step 4: Update Maximum Sum
            maxSum = Math.max(maxSum, prefixSum[right] - prefixSum[left]);

            // Update last seen index
            lastSeen[val] = right;
        }

        // Step 5: Return the Result
        return maxSum;
    }
}   