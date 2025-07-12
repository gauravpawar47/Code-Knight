class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        if(nums.length == 0)
        {
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int n : nums)
        {
            set.add(n);
        }

        int maxSeq = 1;
        int seq = 1;
        Integer[] arr = set.toArray(new Integer[0]);
        
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] - arr[i - 1] == 1)
            {
                seq++;
            }
            else
            {
                maxSeq = Math.max(maxSeq, seq);
                seq = 1;
            }
        }  

        return Math.max(maxSeq, seq);
    }
}