class Solution
{
    public int distinctAverages(int[] nums) 
    {
        HashSet<Float> set = new HashSet<>();
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left <= right)
        {
            set.add((nums[left] + nums[right]) / 2.0f);
            left++;
            right--;     
        }    

        return set.size();
    }
}