class Solution 
{
    public boolean isDivisible(int n)
    {
        int[] map = new int[10];
        int num = n;
        while(n > 0)
        {
            int ld = n % 10;
            if(ld == 0)
            {
                return false;
            }

            map[ld]++;
            n /= 10;
        }

        for(int i = 0; i < 10; i++)
        {
            if(map[i] > 0)
            {
                if(num % i != 0)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) 
    {
        List<Integer> result = new ArrayList<>();
        while(left <= right)
        {
            if(isDivisible(left))
            {
                result.add(left);
            }

            left++;
        }    

        return result;
    }
}