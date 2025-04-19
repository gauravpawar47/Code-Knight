class Solution 
{
    public void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> result)
    {
        // Step 1 : Base-Case
        if(i == nums.length)
        { 
            result.add(new ArrayList<>(curr));
            return;
        }

        // Step 2 : Kaam & Inner Function Call  
        backtrack(nums, i + 1, curr, result);
        curr.add(nums[i]);
        backtrack(nums, i + 1, curr, result);

        // Step 3 : Backtrack Step
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;    
    }
}