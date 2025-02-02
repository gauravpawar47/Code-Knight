class Solution
{
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

        int left = 0;
        int right = sb.length() - 1;
        while(left <= right)
        {
            if(sb.charAt(left) != sb.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}