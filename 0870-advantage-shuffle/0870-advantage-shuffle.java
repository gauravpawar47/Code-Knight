class Solution 
{
    public int[] advantageCount(int[] nums1, int[] nums2) 
    {
        // Step 1 : Sort the Nums1
        int n = nums1.length;
        Arrays.sort(nums1);

        // Step 2 : Sort the Nums2 but make it Index Wise Sorting
        int[][] indexNums2 = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            indexNums2[i][0] = nums2[i];
            indexNums2[i][1] = i;
        }
        Arrays.sort(indexNums2, Comparator.comparingInt(a -> a[0]));

        // Step 3 : Initialize Pointers
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        // Step 4 : Assing Values Using Two Pointers
        for(int i = n - 1; i >= 0; i--)
        {
            int idx = indexNums2[i][1];
            if(nums1[right] > indexNums2[i][0])
            {
                result[idx] = nums1[right];
                right--;
            }
            else
            {
                result[idx] = nums1[left];
                left++;
            }
        }
        return result;
    }
}