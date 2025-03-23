class Solution 
{
    public int minimumOperations(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }    

        HashSet<Integer> seen = new HashSet<>();
        int operations = 0;
        for (int i = nums.length - 1; i >= 0; i--) 
        {
            if (seen.contains(nums[i])) 
            {
                operations = (i / 3) + 1;
                break;
            }
            seen.add(nums[i]);
        }
        
        return operations;
    }
}