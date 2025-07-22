class Solution 
{
    public int getEleSum(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public int differenceOfSum(int[] nums) 
    {
        int digitSum = 0;
        int eleSum = 0;

        for(int n : nums)
        {
            digitSum += n;
            eleSum += getEleSum(n);
        }
        
        return Math.abs(digitSum - eleSum);    
    }
}