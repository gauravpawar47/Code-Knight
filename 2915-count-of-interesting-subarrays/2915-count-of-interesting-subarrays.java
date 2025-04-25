class Solution 
{
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) 
    {
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L); // Base case for prefix sum mod
        
        int prefix = 0;
        long result = 0;

        for (int num : nums) 
        {
            // Count how many numbers so far satisfy num % modulo == k
            if (num % modulo == k) 
            {
                prefix++;
            }

            int mod = prefix % modulo;
            // Adjust for negative modulo result if needed
            int target = (mod - k + modulo) % modulo;

            result += countMap.getOrDefault(target, 0L);
            countMap.put(mod, countMap.getOrDefault(mod, 0L) + 1);
        }

        return result;
    }
}