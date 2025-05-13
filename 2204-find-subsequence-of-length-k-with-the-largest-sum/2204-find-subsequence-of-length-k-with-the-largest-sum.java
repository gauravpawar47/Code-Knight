class Solution 
{
    public int[] maxSubsequence(int[] nums, int k) 
    {
        List<int[]> indexed = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            indexed.add(new int[]{nums[i], i});
        }    

        indexed.sort((a, b) -> b[0] - a[0]);
        List<int[]> topK = indexed.subList(0, k);
        topK.sort(Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = topK.get(i)[0]; 
        }

        return result;
    }
}