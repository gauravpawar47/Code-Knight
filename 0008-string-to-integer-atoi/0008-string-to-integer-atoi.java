class Solution 
{
    public int myAtoi(String s) 
    {
        if(s.isEmpty() || s == null)
        {
            return 0;
        }       

        s = s.trim();
        if(s.length() == 0)
        {
            return 0;
        }

        boolean isNegative = false;
        int idx = 0;

        if(s.charAt(0) == '-')
        {
            isNegative = true;
            idx++;
        }
        else if(s.charAt(0) == '+')
        {
            idx++;
        }

        while(idx < s.length() && s.charAt(idx) == '0')
        {
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while(idx < s.length() && Character.isDigit(s.charAt(idx)))
        {
            sb.append(s.charAt(idx));
            idx++;
        }

        if(sb.length() == 0)
        {
            return 0;
        }

        try
        {
            long num = Long.parseLong(sb.toString());
            if(isNegative)
            {
                num = -num;
            }

            if(num < Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }

            if(num > Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }

            return (int) num;
        }
        catch (NumberFormatException e)
        {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}