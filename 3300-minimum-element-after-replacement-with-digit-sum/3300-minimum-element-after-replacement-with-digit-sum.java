class Solution
{
    public int digitsSum(int num)
    {
        int sum = 0;
        while(num > 0)
        {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minElement(int[] nums) 
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            nums[i] = digitsSum(nums[i]);
            min = Math.min(nums[i], min);
        }   

        return min;
    }
}