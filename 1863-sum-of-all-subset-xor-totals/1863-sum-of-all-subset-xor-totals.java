class Solution 
{
    public void populate(int[] nums, int i, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> currSubset)
    {
        // Step 1 : Base-Case
        if(i == nums.length)
        {
            subsets.add(new ArrayList<>(currSubset));
            return; 
        }

        // Step 2 : Kaam & Inner Function Call
        currSubset.add(nums[i]);
        populate(nums, i + 1, subsets, currSubset);

        // Step 3 : Backtrack Step
        currSubset.remove(currSubset.size() - 1);
        populate(nums, i + 1, subsets, currSubset);   
    }

    public int subsetXORSum(int[] nums) 
    {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> currSubset = new ArrayList<>();
        populate(nums, 0, subsets, currSubset);

        int result = 0;
        for(ArrayList<Integer> subset : subsets)
        {
            int xor = 0 ;
            for(int n : subset)
            {
                xor ^= n;
            }

            result += xor;
        }
        return result;
    }
}