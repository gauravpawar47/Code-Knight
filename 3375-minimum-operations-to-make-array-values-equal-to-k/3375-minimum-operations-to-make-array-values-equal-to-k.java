class Solution 
{
    public int minOperations(int[] nums, int k) 
    {
        // Step 1: If array has only 1 element
        if (nums.length == 1) 
        {
            if (nums[0] == k)
            {
                return 0;
            } 
            else if (nums[0] > k)
            {
                return 1;
            } 
            else
            {
                return -1;
            } 
        }

        // Step 2: Track values > k in a set and count how many are already equal to k
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;

        for (int n : nums) 
        {
            if (n == k) 
            {
                cnt++;
            }
            else if (n > k) 
            {
                set.add(n);
            }
            else 
            {
                // If any value < k, it's impossible
                return -1;
            }
        }

        // Step 3: Check if all are already k
        if (set.size() == 0 && cnt == nums.length) 
        {
            return 0;
        } 
        else if (set.size() == 0) 
        {
            return -1;
        } 
        else 
        {
            return set.size();
        }
    }
}