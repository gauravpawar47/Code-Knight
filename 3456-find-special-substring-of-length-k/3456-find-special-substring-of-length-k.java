class Solution 
{
    public boolean hasSpecialSubstring(String s, int k) 
    {
        int len = s.length();
        for(int i = 0; i <= len - k; i++)
        {
            char curr = s.charAt(i);
            boolean flag = true;

            for(int j = i; j < i + k; j++)
            {
                if(s.charAt(j) != curr)
                {
                    flag = false;
                    break;
                }
            }

            if(flag)
            {
                if(i > 0 && s.charAt(i - 1) == curr)
                {
                    continue;
                }

                if(i + k < len && s.charAt(i + k) == curr)
                {
                    continue;
                }

                return true;
            }
        }

        return false;
    }
}