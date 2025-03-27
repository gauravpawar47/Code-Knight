class Solution 
{
    public int minimumIndex(List<Integer> nums) 
    {
        int N = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }    

        int x = -1;
        int f = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > N / 2)
            {
                x = entry.getKey();
                f = entry.getValue();
                break;
            }
        }

        if(x == -1)
        {
            return -1;
        }

        int lc = 0;
        for(int i = 0; i < N; i++)
        {
            if(nums.get(i) == x)
            {
                lc++;
            }

            int ls = i + 1;
            int rs = N - ls;
            int rc = f - lc;

            if(lc * 2 > ls && rc * 2 > rs)
            {
                return i;
            }
        }

        return -1;
    }
}