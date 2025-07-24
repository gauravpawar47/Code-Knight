class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int[] map = new int[100001];
        for(int n : nums)
        {
            map[n]++;
        }

        int j = 0;
        for(int i = 1; i < map.length; i++)
        {
            if(j == nums.length)
            {
                break;
            }

            if(map[i] != 1)
            {
                return i;
            }
            j++;
        }

        return 0;
    }
}