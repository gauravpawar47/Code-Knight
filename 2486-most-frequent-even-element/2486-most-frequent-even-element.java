class Solution 
{
    public int mostFrequentEven(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
        {
            if(n % 2 == 0)
            {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }    

        if(map.isEmpty())
        {
            return -1;
        }

        int maxFreq = 0;
        int result = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int num = entry.getKey();
            int freq = entry.getValue();

            if(freq > maxFreq || (freq == maxFreq && num < result))
            {
                maxFreq = freq;
                result = num;
            }
        }

        return result;
    }
}