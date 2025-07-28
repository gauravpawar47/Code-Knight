class Solution 
{
    public int maxOr = 0;
    public int count = 0;

    public int countMaxOrSubsets(int[] nums) 
    {
        // Step 2: Compute the maximum OR by OR-ing all elements
        maxOr = 0;
        for (int num : nums) 
        {
            maxOr |= num;
        }

        // Step 3: Start the recursive backtracking from index 0
        count = 0;
        backtrack(nums, 0, 0);
        
        // Step 6: Return the final count of valid subsets
        return count;
    }

    // Step 3: Recursive backtracking function
    public void backtrack(int[] nums, int index, int currentOr) 
    {
        // Step 4: If all elements are processed
        if (index == nums.length) 
        {
            // Step 4: If OR equals the max OR, increment count
            if (currentOr == maxOr) 
            {
                count++;  // Valid subset found
            }
            
            return;
        }

        // Step 5: Explore both include and exclude cases
        // Include current number
        backtrack(nums, index + 1, currentOr | nums[index]);

        // Exclude current number
        backtrack(nums, index + 1, currentOr);
    }
}