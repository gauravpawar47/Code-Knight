class Solution
{
    public int largestInteger(int[] nums, int k) 
    {
        int[] map = new int[51];
        for(int i = 0; i <= nums.length - k; i++)
        {
            int j = i;
            HashSet<Integer> seen = new HashSet<>();
            while(j < i + k)
            {
                if(!seen.contains(nums[j]))
                {
                    map[nums[j]]++;
                    seen.add(nums[j]);
                }
                
                j++;
            }
        }    

        for(int i = map.length - 1; i >= 0; i--)
        {
            if(map[i] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}