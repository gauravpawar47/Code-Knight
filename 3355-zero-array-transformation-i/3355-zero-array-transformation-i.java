class Solution 
{
    public boolean isZeroArray(int[] nums, int[][] queries) 
    {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for (int[] query : queries) 
        {
            int l = query[0];
            int r = query[1];

            map.put(l, map.getOrDefault(l, 0) - 1);
            map.put(r + 1, map.getOrDefault(r + 1, 0) + 1);
        }

        int decrement = 0;
        for (int i = 0; i < n; i++) 
        {
            decrement += map.getOrDefault(i, 0);  
            nums[i] += decrement;  
        }

        for (int num : nums) 
        {
            if (num > 0)
            {
                return false;
            } 
        }

        return true;
    }
}