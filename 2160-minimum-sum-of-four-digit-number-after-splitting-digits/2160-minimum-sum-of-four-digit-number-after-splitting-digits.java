class Solution 
{
    public int minimumSum(int num) 
    {
        int[] digits = new int[4];
        int curr = 0;

        while(num > 0)
        {
            digits[curr++] = num % 10;
            num /= 10;
        }          

        Arrays.sort(digits);
        int n1 = digits[0] * 10 + digits[2];
        int n2 = digits[1] * 10 + digits[3];

        return n1 + n2;
    }
}