class Solution
{
    public int digitsSum(int num)
    {
        int sum = 0;
        while(num > 0)
        {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int getLucky(String s, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            list.add(s.charAt(i) - 'a' + 1);
        }

        for(int i = 0; i < list.size(); i++)
        {
            list.set(i, digitsSum(list.get(i)));
            sum += list.get(i);
        }

        if(k == 1)
        {
            return sum;
        }    

        while(k > 1)
        {
            sum = digitsSum(sum);
            k--;
        }    

        return sum;
    }
}