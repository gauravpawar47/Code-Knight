class Solution 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        if(n == 0)
        {
            return;
        }

        int[] arr = new int[m + n];
        for(int i = 0; i < m; i++)
        {
            arr[i] = nums1[i];
        }

        for(int j = m; j < m + n; j++)
        {
            arr[j] = nums2[j - m];
        }

        mergeSort(arr, 0, (m + n) - 1);
        for(int i = 0; i < m; i++)
        {
            nums1[i] = arr[i];
        }

        for(int j = m; j < m + n; j++)
        {
            nums1[j] = arr[j];
        }
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

    public void merge(int[] arr, int si, int mid, int ei)
    {
        int i = si;
        int j = mid + 1;

        int[] temp = new int[ei - si + 1];
        int k = 0;

        while(i <= mid && j <= ei)
        {
            if(arr[i] < arr[j])
            {
                temp[k] = arr[i];
                i++;
                k++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i <= mid)
        {
            temp[k++] = arr[i++];
        }

        while(j <= ei)
        {
            temp[k++] = arr[j++];
        }

        for(i = si; i <= ei; i++)
        {
            arr[i] = temp[i - si];
        }
    }
}