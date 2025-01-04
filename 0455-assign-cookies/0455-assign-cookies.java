class Solution
{
    public int findContentChildren(int[] g, int[] s)
    {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int count = 0;
        while(i < g.length)
        {
            int j = 0;
            while(j < s.length)
            {
                if(i < g.length && s[j] >= g[i])
                {
                    count++;
                    i++;
                }
                j++;
            }

            if(j == s.length)
            {
                break;
            }
            i++;
        }

        return count;
    }
}