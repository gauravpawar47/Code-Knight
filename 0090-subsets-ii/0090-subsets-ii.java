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

        // Step 2 : Inner Function Call (Include)
        current.add(nums[i]);
        findSubsets(nums, i + 1, result, current);

        // Step 3 : Backtrack Step
        current.remove(current.size() - 1);

        // Step 4 : Skip Duplicates
        while(i + 1 < nums.length && nums[i] == nums[i + 1])
        {
            i++;
        }

        // Step 5 : Inner Function Call (Exclude)
        findSubsets(nums, i + 1, result, current);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, 0, result, new ArrayList<Integer>());
        return result;    
    }
}