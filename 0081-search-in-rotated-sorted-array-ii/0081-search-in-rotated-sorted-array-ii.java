class Solution 
{
    public boolean search(int[] nums, int target) 
    {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int n : nums)
        {
            set.add(n);
        }    

        nums = new int[set.size()];
        int i = 0;
        for(int n : set)
        {
            nums[i] = n;
            i++;
        }

        return helper(nums, 0, nums.length - 1, target);
    }

    public boolean helper(int[] arr, int si, int ei, int target)
    {
        if(si > ei)
        {
            return false;
        }

        int mid = (si + ei) / 2;
        if(arr[mid] == target)
        {
            return true;
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
}