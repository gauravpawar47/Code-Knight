class Solution 
{
    public int mySqrt(int x) 
    {
        if(x == 1 || x == 2 || x == 3)
        {
            return 1;
        }

        for(long i = 0; i <= x / 2 + 1; i++)
        {
            if(i * i > x)
            {
                return (int) i - 1;
            }

            if(i * i == x)
            {
                return (int) i;
            }
        }

        return -1;
    }
}