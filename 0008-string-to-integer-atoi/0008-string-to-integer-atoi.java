class Solution
{
    public int getAtoi(String s, int i, int n, int result, boolean isNegative)
    {
        // Step 1 : Base-Case
        if(i == n || !Character.isDigit(s.charAt(i)))
        {
            return result;
        }

        // Step 2 : Kaam
        int curr = s.charAt(i) - '0';
        if (result > (Integer.MAX_VALUE - curr) / 10)
        {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        result = result * 10 + curr;

        // Step 3 : Inner Function Call
        return getAtoi(s, i + 1, n, result, isNegative);
    }

    public int myAtoi(String s)
    {
        s = s.trim();
        if(s.length() == 0)
        {
            return 0;
        }

        int i = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;
        boolean isNegative = s.charAt(0) == '-';

        return isNegative ? -getAtoi(s, i, s.length(), 0, isNegative) : getAtoi(s, i, s.length(), 0, isNegative);
    }
}