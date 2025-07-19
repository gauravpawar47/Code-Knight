class Solution 
{
    public int helper(int[] arr, int si, int ei, int target)
    {
        if(si > ei)
        {
            return -1;
        }

        int mid = si + (ei - si) / 2;
        if(arr[mid] == target)
        {
            return mid;
        }

        if(arr[si] <= arr[mid])
        {
            if(arr[si] <= target && target <= arr[mid])
            {
                return helper(arr, si, mid - 1, target);
            }
            else
            {
                return helper(arr, mid + 1, ei, target);
            }
        }
        else
        {
            if(arr[mid] <= target && target <= arr[ei])
            {
                return helper(arr, mid + 1, ei, target);
            }
            else
            {
                return helper(arr, si, mid - 1, target);
            }
        }
    }

    public int search(int[] nums, int target) 
    {
        return helper(nums, 0, nums.length - 1, target);
    }
}