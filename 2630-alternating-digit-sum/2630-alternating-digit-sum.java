class Solution
{
    public int alternateDigitSum(int n) 
    {
        String s = String.valueOf(n);
        int sum = 0;

        for(int i = 0; i < s.length(); i++)
        {
            int num = s.charAt(i) - '0';
            if(i % 2 == 0)
            {
                sum += num;
            }
            else
            {
                sum += -num;
            }
        } 

        return sum;
    }
}