class Solution 
{
    public int arrangeCoins(int n) 
    {   
        int i = 0;
        while(n >= 0)
        {   
            n -= (i + 1);
            i++;
        }    

        return i - 1;
    }
}