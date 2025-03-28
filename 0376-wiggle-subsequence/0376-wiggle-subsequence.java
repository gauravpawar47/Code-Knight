class Solution 
{
    public int wiggleMaxLength(int[] nums) 
    {
        if (nums.length < 2)
        {
            return nums.length; // Base case
        } 

        int wiggle = 1; // Always count the first element
        int i = 1;

        // Find the first valid up/down trend
        while (i < nums.length && nums[i] == nums[i - 1]) 
        {
            i++;
        }
        
        if (i == nums.length)
        {
            return 1; // All elements are the same
        } 

        boolean last = nums[i] > nums[i - 1]; // First trend found
        wiggle++; // Count the first trend change

        for (; i < nums.length; i++) 
        {
            if (last && nums[i] - nums[i - 1] < 0) 
            {
                last = false;
                wiggle++;
            } 
            else if (!last && nums[i] - nums[i - 1] > 0) 
            {
                last = true;
                wiggle++;
            }
        }

        return wiggle;
    }
}