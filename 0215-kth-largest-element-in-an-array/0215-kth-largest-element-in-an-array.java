class Solution
{
    public int findKthLargest(int[] nums, int k)
    {
        Arrays.sort(nums);
        return nums[nums.length - 1 - k + 1];
    }
}