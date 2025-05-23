class Solution 
{
    public int maxProduct(int n) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0)
        {
            int ld = n % 10;
            list.add(ld);
            n /= 10;
        }

        Collections.sort(list, Collections.reverseOrder());
        return list.get(0) * list.get(1);
    }
}