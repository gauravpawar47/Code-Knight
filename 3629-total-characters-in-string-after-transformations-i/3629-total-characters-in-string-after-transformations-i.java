class Solution 
{
    public int lengthAfterTransformations(String s, int t) 
    {
        int MOD = 1_000_000_007;
        int n = s.length();
        int[] map = new int[26];

        for(char c : s.toCharArray())
        {
            map[c - 'a']++;
        }

        for(int count = 1; count <= t; count++)
        {
            int[] temp = new int[26];
            for(int i = 0; i < 26; i++)
            {
                char c = (char) (i + 'a');
                int f = map[i];

                if(c != 'z')
                {
                    temp[(c + 1) - 'a'] = (temp[(c + 1) - 'a'] + f) % MOD;
                }
                else
                {
                    temp['a' - 'a'] = (temp['a' - 'a'] + f) % MOD;
                    temp['b' - 'a'] = (temp['b' - 'a'] + f) % MOD;
                }
            }

            map = temp;
        }

        int result = 0;
        for(int i = 0; i < 26; i++)
        {
            result = (result + map[i]) % MOD;
        }

        return result;
    }
}