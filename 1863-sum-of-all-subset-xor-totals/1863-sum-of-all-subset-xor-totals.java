class Solution 
{
    public int subsetXORSum(int[] nums) 
    {
        return backtrack(nums, 0, 0);    
    }

    public static int backtrack(int[] nums, int i, int sum)
    {
        // Step 1 : Base-Case
        if(i == nums.length)
        {
            return sum;
        }

        // Step 2 : Kaam
        int include = backtrack(nums, i + 1, sum ^ nums[i]);
        int exclude = backtrack(nums, i + 1, sum);

        // Step 3 : Inner Function Call
        return include + exclude;
    }
}