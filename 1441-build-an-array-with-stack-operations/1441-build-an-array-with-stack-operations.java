class Solution
{
    public List<String> buildArray(int[] target, int n)
    {
        ArrayList<String> list = new ArrayList<>();
        int digit = 1;
        int i = 0;

        while(i < target.length)
        {
            list.add("Push");
            if(digit == target[i])
            {
                i++;
            }
            else
            {
                list.add("Pop");
            }
            digit++;
        }   

        return list;    
    }
}