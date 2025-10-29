class Solution 
{
    public int[] recoverOrder(int[] order, int[] friends) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int friend : friends)
        {
            set.add(friend);
        }    

        int j = 0;
        for(int i = 0; i < order.length && j < friends.length; i++)
        {
            if(set.contains(order[i]))
            {
                friends[j] = order[i];
                j++;
            }
        }

        return friends;
    }
}