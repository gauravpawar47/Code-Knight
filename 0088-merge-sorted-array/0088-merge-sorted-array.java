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

        Arrays.sort(arr);
        for(int i = 0; i < m + n; i++)
        {
            nums1[i] = arr[i];
        }
    }

    
}