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

    public int countEven(int num)
    {
        int count = 0;
        for(int i = 1; i <= num; i++)
        {
            if(digitsSum(i) % 2 == 0)
            {
                count += 1;
            }
        }

        return count;
    }
}