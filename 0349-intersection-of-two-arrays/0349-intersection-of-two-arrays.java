class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums1)
        {
            set.add(n);
        }

        HashSet<Integer> result = new HashSet<>();
        for(int n : nums2)
        {
            if(set.contains(n))
            {
                result.add(n);
            }
        }

        int i = 0;
        int[] arr = new int[result.size()];

        for(int n : result)
        {
            arr[i] = n;
            i++;    
        }

        return arr;
    }
}