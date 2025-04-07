class Solution 
{
    int[][] t = new int[201][20001];
    public boolean solve(int[] nums, int i, int x)
    {
        // Step 1 : Base-Case
        if(x == 0)
        {
            return true;
        }
        
        if(t[i][x] != -1)
        {
            return t[i][x] == 1;
        } 

        if(i >= nums.length)
        {
            return false;
        }

        // Step 2 : Kaam & Inner Function Call
        boolean take = false;
        if(nums[i] <= x)
        {
            take = solve(nums, i + 1, x - nums[i]);
        }

        boolean notTake = solve(nums, i + 1, x);
        t[i][x] = (take || notTake) ? 1 : 0;
        
        return take || notTake;
    }

    public boolean canPartition(int[] nums) 
    {
        int sum = 0;
        int size = nums.length;

        for(int n : nums)
        {
            sum += n;
        }
        if(sum % 2 != 0)
        {
            return false;
        }

        for (int[] row : t) 
        {
            Arrays.fill(row, -1);
        }

        int x = sum / 2;
        return solve(nums, 0, x);
    }
}