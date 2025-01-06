class Solution
{
    public int thirdMax(int[] nums) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        if(list.size() >= 3)
        {
            return list.get(2);
        }
        else
        {
            return list.get(0);
        }
    }
}