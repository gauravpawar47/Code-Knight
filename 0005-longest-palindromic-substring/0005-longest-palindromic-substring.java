class Solution 
{
    public String longestPalindrome(String s) 
    {
        int maxLen = Integer.MIN_VALUE;
        String result = "";

        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                String substr = s.substring(i, j + 1);
                if(isPalindrome(substr) && substr.length() > maxLen)
                {
                    result = substr;
                    maxLen = substr.length();
                }
            }
        }    

        return result;
    }

    public boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}