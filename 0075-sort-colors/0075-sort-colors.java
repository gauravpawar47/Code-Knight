class Solution 
{
    public void sortColors(int[] nums) 
    {
        mergeSort(nums, 0, nums.length - 1);    
    }

    public void mergeSort(int[] arr, int si, int ei)
    {
        if(si >= ei)
        {
            return;
        }

        int mid = (si + ei) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public void merge(int[] nums, int si, int mid, int ei)
    {
        int i = si;
        int j = mid + 1;

        int[] temp = new int[ei - si + 1];
        int k = 0;

        while(i <= mid && j <= ei)
        {
            if(nums[i] <= nums[j])
            {
                temp[k] = nums[i];
                i++;
            }
            else
            {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        while(i <= mid)
        {
            temp[k++] = nums[i++];
        }

        while(j <= ei)
        {
            temp[k++] = nums[j++];
        }

        for(int m = 0; m < temp.length; m++)
        {
            nums[m + si] = temp[m];
        }
    }
}