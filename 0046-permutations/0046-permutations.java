class Solution 
{
    public static void permutations(int[] nums, List<List<Integer>> result, List<Integer> current)
    {
        // Step 1 : Base-Case
        if(nums.length == 0)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        // Step 2 : Kaam
        for(int i = 0; i < nums.length; i++)
        {
            int curr = nums[i];
            int[] arr = new int[nums.length - 1];

            System.arraycopy(nums, 0, arr, 0, i);
            System.arraycopy(nums, i + 1, arr, i, nums.length - i - 1);

            current.add(curr);

            // Step 3 : Inner Function Call
            permutations(arr, result, current);

            // Step 4 : Backtrack Step
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums, result, new ArrayList<>());
        return result;
    }
}