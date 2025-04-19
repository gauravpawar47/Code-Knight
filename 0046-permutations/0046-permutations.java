class Solution 
{
    public void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result)
    {
        // Step 1 : Base-Case
        if(curr.size() == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Step 2 : Kaam
        for(int i = 0; i < nums.length; i++)
        {
            // Step 3 : Check if Number is Already present or not
            if(used[i])
            {
                continue;
            }

            // Step 4 : Include Call
            used[i] = true;
            curr.add(nums[i]);

            // Step 5 : Explore
            backtrack(nums, used, curr, result);

            // Step 6 : Backtrack Step
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;    
    }
}