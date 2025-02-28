class Solution
{
    public boolean isString(String s, int left, int right)
    {
        // Step 1 : Base-Case
        if(left >= right)
        {
            return true;
        }

        // Step 2 : Kaam
        if(s.charAt(left) != s.charAt(right))
        {
            return false;
        }

        // Step 3 : Inner Function Call
        return isString(s, left + 1, right - 1);
    }

    public boolean isPalindrome(String s)
    {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
            {
                sb.append(s.charAt(i));
            }
        }
        
        return isString(sb.toString().toLowerCase(), 0, sb.length() - 1);
    }
}