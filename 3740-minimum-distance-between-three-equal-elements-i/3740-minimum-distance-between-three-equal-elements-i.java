class Solution 
{
    public int minimumDistance(int[] nums) 
    {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);   
        }

        int minDis = Integer.MAX_VALUE;
        boolean isFound = false;

        for(List<Integer> list : map.values())
        {
            if(list.size() >= 3)
            {
                for(int i = 0; i + 2 < list.size(); i++)
                {
                    int dist = 2 * (list.get(i + 2) - list.get(i));
                    minDis = Math.min(minDis, dist);
                    isFound = true;
                }
            }
        }

        return isFound ? minDis : -1;
    }
}