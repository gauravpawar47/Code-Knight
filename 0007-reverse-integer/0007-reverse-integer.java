class Solution 
{
    public int reverse(int x) 
    {
        boolean isNegative = x < 0 ? true : false;
        int num = 0;
        
        x = Math.abs(x);
        while(x > 0)
        {
            int ld = x % 10;
            if(num > (Integer.MAX_VALUE - ld) / 10)
            {
                return 0;
            }
            num = (num * 10) + ld;
            x /= 10;
        }    

        return isNegative ? -num : num;
    }
}