class Solution 
{
    public int largestSumAfterKNegations(int[] nums, int k) 
    {
        Arrays.sort(nums);

        int i = 0;
        while(i < nums.length && k > 0 && nums[i] < 0)
        {
            nums[i] = -nums[i];
            i++;
            k--;
        } 

        Arrays.sort(nums);
        if(k % 2 == 1)
        {
            nums[0] = -nums[0];
        }

        int result = 0;
        for(int num : nums)
        {
            result += num;
        }

        return result;
    }
}