class Solution 
{
    public List<List<Integer>> findMatrix(int[] nums) 
    {
        int[] freq = new int[nums.length + 1];
        for (int num : nums) 
        {
            freq[num]++;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        while(true) 
        {
            List<Integer> currentRow = new ArrayList<>();
            boolean hasElements = false;
            
            for (int i = 1; i < freq.length; i++) 
            {
                if (freq[i] > 0) 
                {
                    currentRow.add(i);
                    freq[i]--;
                    hasElements = true;
                }
            }
            
            if (!hasElements)
            {
                break;
            }            
            result.add(currentRow);
        }
        return result;
    }
}