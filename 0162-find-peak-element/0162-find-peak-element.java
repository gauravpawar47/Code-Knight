class Solution 
{
    public int findPeakElement(int[] nums) 
    {
        if(nums.length == 1)
        {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(mid + 1 < nums.length && nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }    

        return left;
    }
}