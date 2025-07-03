class Solution 
{
    public boolean isPalindrome(int x) 
    {
        int n = x;
        int p = 0;

        Math.abs(x);
        while(x > 0)
        {
            int ld = x % 10;
            p = (p * 10) + ld;
            x /= 10;
        }   

        return  p == n;
    }
}