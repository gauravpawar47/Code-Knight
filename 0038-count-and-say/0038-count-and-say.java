class Solution 
{
    public static String helper(String s, int n)
    {
        // Step 1 : Base-Case
        if(n == 0)
        {
            return s;
        }

        // Step 2 : Kaam

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char curr = s.charAt(0);

        for(int i = 1; i < s.length(); i++)
        {
            if(curr == s.charAt(i))
            {
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(curr);
                count = 1;
                curr = s.charAt(i);
            }
        }

        sb.append(count);
        sb.append(curr);

        // Step 3 : Inner Function Call
        return helper(sb.toString(), n - 1); 
    }

    public String countAndSay(int n) 
    {
        return helper("1", n - 1);
    }
} 