class Solution 
{
    public ArrayList<Integer> getDivisors(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2; i <= n; i++)
        {
            if(n % i == 0)
            {
                list.add(i);
            }
        }

        return list;
    }

    public int findGCD(int[] nums) 
    {
        Arrays.sort(nums);
        int n = nums.length;

        int a = nums[0];    
        int b = nums[n - 1];

        ArrayList<Integer> gcd1 = getDivisors(a);    
        ArrayList<Integer> gcd2 = getDivisors(b);    
    
        int gcd = 1;
        for(int i = 0; i < gcd1.size(); i++)
        {
            if(gcd2.contains(gcd1.get(i)))
            {
                gcd = Math.max(gcd, gcd1.get(i));
            }
        }

        return gcd;
    }
}