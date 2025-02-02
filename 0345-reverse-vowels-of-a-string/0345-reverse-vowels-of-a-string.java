class Solution
{
    public boolean isVowel(char ch)
    {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    public String reverseVowels(String s)
    {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        while(left < right)  // Ensure left is strictly less than right
        {
            while(left < right && !isVowel(sb.charAt(left))) 
            {
                left++;  // Move left pointer until a vowel is found
            }
            while(left < right && !isVowel(sb.charAt(right))) 
            {
                right--;  // Move right pointer until a vowel is found
            }

            if(left < right)
            {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);

                left++;
                right--;
            }
        }

        return sb.toString();
    }
}
