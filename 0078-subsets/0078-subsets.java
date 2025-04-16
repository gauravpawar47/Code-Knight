class Solution 
{
    public static void findSubsets(int[] nums, int i, List<List<Integer>> result, ArrayList<Integer> current)
    {
        // Step 1 : Base-Case
        if(i == nums.length)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        findSubsets(nums, i + 1, result, current);
        current.add(nums[i]);
        findSubsets(nums, i + 1, result, current);
        current.remove(current.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, 0, result, new ArrayList<Integer>());       
        return result;
    }
}