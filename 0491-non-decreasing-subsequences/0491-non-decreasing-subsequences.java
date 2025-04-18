class Solution 
{
    public void backtrack(int[] nums, int i, List<List<Integer>> result, List<Integer> current) 
    {
        // Step 1: Base-Case - 
        if (current.size() >= 2) 
        {
            result.add(new ArrayList<>(current));  
        }

        // Step 2: Recursively explore subsequences
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) 
        {
            // Step 3 : Ensure the subsequence is strictly increasing
            if ((current.isEmpty() || nums[j] >= current.get(current.size() - 1)) && !set.contains(nums[j])) 
            {
                set.add(nums[j]);
                current.add(nums[j]);
                // Step 4 : Inner Function Call
                backtrack(nums, j + 1, result, current);  

                // Step 5 : Backtrack Step
                current.remove(current.size() - 1);  
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }
}
