class Solution 
{
    public boolean kLengthApart(int[] nums, int k) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        int distance = -1;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                if(distance != -1)
                {
                    list.add(distance);
                }

                distance = 0;
            }
            else if(distance != -1)
            {
                distance++;
            }
        }    

        for(int n : list)
        {
            if(n < k)
            {
                return false;
            }
        }

        
        return true;
    }
}