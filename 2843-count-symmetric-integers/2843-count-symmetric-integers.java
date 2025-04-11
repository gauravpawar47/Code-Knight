class Solution 
{
    public int countSymmetricIntegers(int low, int high) 
    {
        int count = 0;
        for(int i = low; i <= high; i++)
        {
            String s = Integer.toString(i);
            if(s.length() % 2 != 0)
            {
                continue;
            }

            int leftSum = 0;
            int rightSum = 0;

            int l = 0;
            int r = s.length() - 1;            
            
            while(l <= r)
            {
                leftSum += s.charAt(l) - '0';
                l++;
                
                rightSum += s.charAt(r) - '0';
                r--;
            }

            if(leftSum == rightSum)
            {
                count++;
            }
        }   

        return count;
    }
}