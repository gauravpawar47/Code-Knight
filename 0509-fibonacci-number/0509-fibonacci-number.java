class Solution 
{
    public int fib(int n) 
    {
        // Step 1 : Base-Case
        if(n == 1 || n == 0)
        {
            return n;
        } 

        // Step 2 : Kaam & Inner Function Call
        return fib(n - 1) + fib(n - 2);
    }
}