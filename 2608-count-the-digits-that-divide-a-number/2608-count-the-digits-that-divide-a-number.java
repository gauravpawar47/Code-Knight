class Solution 
{
    public int countDigits(int n) 
    {
        int[] map = new int[10];
        int temp = n;
        while(temp > 0)
        {
            int ld = temp % 10;
            map[ld]++;
            temp /= 10;
        }

        int count = 0;
        for(int i = 0; i < 10; i++)
        {
            if(map[i] > 0)
            {
                if(n % i == 0)
                {
                    count += map[i];
                }
            }
        }

        return count;
    }
}