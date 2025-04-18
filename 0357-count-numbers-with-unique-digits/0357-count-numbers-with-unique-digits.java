class Solution 
{
    public int countNumbersWithUniqueDigits(int n) 
    {
        if(n == 0)
        {
            return 1;
        }   

        int result = 10;
        int uniquePos = 9;
        int availPos = 9;

        for(int i = 2; i <= n; i++)
        {
            uniquePos *= availPos;
            availPos--;
            result += uniquePos;
        }

        return result;
    }
}