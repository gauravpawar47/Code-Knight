class Solution 
{
    public boolean digitCount(String num) 
    {
        int[] map = new int[10];
        for(char c : num.toCharArray())
        {
            map[c - '0']++;
        }

        for(int i = 0; i < num.length(); i++)
        {
            char c = num.charAt(i);
            int v = map[i];

            if(c - '0' != v)
            {
                return false;
            }
        }

        return true;
    }
}