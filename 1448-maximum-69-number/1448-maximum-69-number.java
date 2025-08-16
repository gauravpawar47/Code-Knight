class Solution 
{
    public int maximum69Number (int num) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        while(num > 0)
        {
            list.add(num % 10);
            num /= 10;
        }

        Collections.reverse(list);
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) < 9)
            {
                list.set(i, 9);
                break;
            }
        }

        int sol = 0;
        for(int n : list)
        {
            sol = sol * 10 + (n);
        }

        return sol;
    }
}