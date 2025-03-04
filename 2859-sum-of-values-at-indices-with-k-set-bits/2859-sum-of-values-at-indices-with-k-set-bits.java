class Solution 
{
    public int getBinary(int n)
    {
        StringBuilder bin = new StringBuilder();

        while(n > 0)
        {   
            int rem = n % 2;
            bin.insert(0, rem);
            n /= 2;
        }   

        int binary = 0;
        for(int i = 0; i < bin.length(); i++)
        {
            if(bin.charAt(i) == '1')
            {
                binary++;
            }
        }

        return binary;
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) 
    {
        int sum = 0;
        for(int i  = 0; i < nums.size(); i++)
        {
            if(getBinary(i) == k)
            {
                sum += nums.get(i);
            }
        } 

        return sum;
    }
}