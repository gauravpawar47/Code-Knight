class Solution 
{
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) 
    {
        HashSet<Integer> set1 = new HashSet<>();
        for(int n : nums1)
        {
            set1.add(n);
        }    

        for(int n : nums2)
        {
            if(set1.contains(n))
            {
                set1.remove(n);
            }
        } 

        HashSet<Integer> set2 = new HashSet<>();
        for(int n : nums2)
        {
            set2.add(n);
        }    

        for(int n : nums1)
        {
            if(set2.contains(n))
            {
                set2.remove(n);
            }
        } 

        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));
    }
}