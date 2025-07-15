class Solution 
{
    public int reversePairs(int[] nums) 
    {
        return mergeSort(nums, 0, nums.length - 1);    
    }

    public int mergeSort(int[] nums, int si, int ei)
    {
        if(si >= ei) 
        {
            return 0;
        }

        int mid = (si + ei) / 2;
        
        int leftCount = mergeSort(nums, si, mid);
        int rightCount = mergeSort(nums, mid + 1, ei);
        
        int count = leftCount + rightCount;
        
        int j = mid + 1;
        for(int i = si; i <= mid; i++)
        {
            while(j <= ei && (long) nums[i] > 2L* nums[j])
            {
                j++;
            }
            count += (j - (mid + 1));
        }
        
        merge(nums, si, mid, ei);
        return count;
    }

    public void merge(int[] nums, int si, int mid, int ei)
    {
        int i = si;
        int j = mid + 1;

        int k = 0;
        int[] temp = new int[ei - si + 1];

        while(i <= mid && j <= ei)
        {
            if(nums[i] < nums[j])
            {
                temp[k] = nums[i];
                i++;
                k++;
            }
            else
            {
                temp[k] = nums[j];
                j++;
                k++;
            }
        }

        while(i <= mid)
        {
            temp[k++] = nums[i++];
        }

        while(j <= ei)
        {
            temp[k++] = nums[j++];
        }

        for(i = si; i <= ei; i++)
        {
            nums[i] = temp[i - si];
        }
    }
}