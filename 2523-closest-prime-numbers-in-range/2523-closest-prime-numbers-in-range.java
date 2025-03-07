class Solution 
{
    public boolean isPrime(int n)
    {
        if (n <= 1) 
        {
            return false;
        }

        if (n == 2 || n == 3) 
        {
            return true;
        }

        if (n % 2 == 0) 
        {
            return false;
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) 
        {
            if (n % i == 0) 
            {
                return false;
            }
        }

        return true;
    }

    public int[] closestPrimes(int left, int right) 
    {   
        ArrayList<Integer> list = new ArrayList<>();
        while(left <= right)
        {
            if(isPrime(left))
            {
                list.add(left);
            }
            left++;
        }

        if(list.size() < 2)
        {
            return new int[]{-1, -1};
        }

        int minIdx = 0;
        int minPair = Integer.MAX_VALUE;

        for(int i = 1; i < list.size(); i++)
        {
            int diff = list.get(i) - list.get(i - 1);
            if(diff < minPair)
            {
                minPair = diff;
                minIdx = i - 1;
            }
        }

        return new int[]{list.get(minIdx), list.get(minIdx + 1)};
    }
}