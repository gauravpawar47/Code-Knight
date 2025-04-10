class Solution 
{
    public String largestGoodInteger(String num) 
    {
        String max = "";
        
        for (int i = 0; i < num.length() - 2; i++) 
        {
            char a = num.charAt(i);
            if (a == num.charAt(i + 1) && a == num.charAt(i + 2)) 
            {
                String candidate = "" + a + a + a;
                if (max.compareTo(candidate) < 0) 
                {
                    max = candidate;
                }
            }
        }
        
        return max;
    }
}