class Solution 
{
    public int countLargestGroup(int n) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++)
        {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int maxGroup = 0;
        for(int value : map.values())
        {
            maxGroup = Math.max(value, maxGroup);
        }

        int count = 0;
        for(int group : map.values())
        {
            if(maxGroup == group)
            {
                count++;
            }
        }

        return count;
    }

    public int digitSum(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            int ld = n % 10;
            sum += ld;
            n /= 10;
        }

        return sum;
    }
}