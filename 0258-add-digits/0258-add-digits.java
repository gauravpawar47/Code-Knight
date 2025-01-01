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

    public int addDigits(int num)
    {
        while(num > 9)
        {
            num = digitsSum(num);
        }    

        return num;
    }
}