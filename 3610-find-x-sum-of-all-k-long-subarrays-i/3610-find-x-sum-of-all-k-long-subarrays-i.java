class Solution 
{
    public int[] findXSum(int[] nums, int k, int x) 
    {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) 
        {
            // Step 1: Extract subarray and count frequencies
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Step 2: Sort elements by frequency (desc), then value (desc)
            ArrayList<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) 
            {
                list.add(new int[]{e.getKey(), e.getValue()});
            }

            list.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // frequency desc
                return b[0] - a[0]; // value desc
            });

            // Step 3: Pick top x elements
            HashSet<Integer> keep = new HashSet<>();
            for (int idx = 0; idx < Math.min(x, list.size()); idx++) 
            {
                keep.add(list.get(idx)[0]);
            }

            // Step 4: Sum occurrences of those kept elements
            int sum = 0;
            for (int j = i; j < i + k; j++) 
            {
                if (keep.contains(nums[j])) 
                {
                    sum += nums[j];
                }
            }

            ans[i] = sum;
        }

        return ans;
    }
}