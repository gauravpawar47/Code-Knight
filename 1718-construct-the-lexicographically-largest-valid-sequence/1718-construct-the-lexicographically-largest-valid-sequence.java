class Solution
{
    public int[] constructDistancedSequence(int n)
    {
        boolean[] map = new boolean[n + 1];
        int[] result = new int[n * 2 - 1];

        Arrays.fill(result, -1);
        solve(0, n, result, map);

        return result;
    }

    public boolean solve(int i, int n, int[] result, boolean[] map)
    {
        if(i >= result.length)
        {
            return true;
        }

        if(result[i] != -1)
        {
            return solve(i + 1, n, result, map);
        }

        for(int num = n; num >= 1; num--)
        {
            if(map[num])
            {
                continue;
            }

            map[num] = true;
            result[i] = num;

            if(num == 1)
            {
                if(solve(i + 1, n, result, map))
                {
                    return true;
                }
            }
            else
            {
                int j = result[i] + i;
                if(j < result.length && result[j] == -1)
                {
                    result[j] = num;
                    if(solve(i + 1, n, result, map))
                    {
                        return true;
                    }

                    result[j] = -1; 
                }
            }

            map[num] = false;
            result[i] = -1;
        }

        return false;
    }
} 