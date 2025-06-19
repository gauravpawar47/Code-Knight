class Solution 
{
    public int minCost(int[] nums, int k) 
    {
        int n = nums.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < n + 1; i++)
        {
            Map<Integer, Integer> map = new HashMap<>();
            int trim = 0;

            for(int j = i - 1; j >= 0; j--)
            {
                int val = nums[j];
                map.put(val, map.getOrDefault(val, 0) + 1);

                int count = map.get(val);
                if(count == 2)
                {
                    trim += 2;
                }
                else if(count > 2)
                {
                    trim += 1;
                }

                int cost = k + trim;
                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }    

        return dp[n];
    }
}