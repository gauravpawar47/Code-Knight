class Solution 
{
    public void rotate(int[] nums, int k) 
    {
        int n = nums.length;
        if(n <= 1 || k % n == 0)
        {
            return;
        }
        
        k = k % n;
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i > n - k - 1; i--)
        {
            stack.push(nums[i]);
        }    

        for(int i = n - k - 1; i >= 0; i--)
        {
            nums[i + k] = nums[i];
        }

        for(int i = 0; i < k; i++)
        {
            nums[i] = stack.pop();
        }
    }
}