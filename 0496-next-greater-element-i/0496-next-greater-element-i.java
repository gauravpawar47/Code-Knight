class Solution
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++)    
        {
            map.put(nums2[i], i);
        }

        int[] arr = new int[nums1.length];
        Arrays.fill(arr, -1);
        for(int i = 0; i < nums1.length; i++)
        {
            for(int j = map.get(nums1[i])+ 1; j < nums2.length; j++)
            {
                if(nums1[i] < nums2[j])
                {
                    arr[i] = nums2[j];
                    break;
                }
            }
        }

        return arr;
    }
}