class Solution 
{
    public static int countCompleteSubarrays(int[] nums) 
    {
        int n = nums.length;
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) 
        {
            distinct.add(num);
        }

        int totalDistinct = distinct.size();
        int result = 0;

        for (int i = 0; i < n; i++) 
        {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) 
            {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
                if (freq.size() == totalDistinct) 
                {
                    result++;
                }
            }
        }

        return result;
    }
}
