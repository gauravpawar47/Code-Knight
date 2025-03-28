class Solution 
{
    public int[] rearrangeArray(int[] nums) 
    {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
            {
                negative.add(nums[i]);
            }
            else
            {
                positive.add(nums[i]);
            }
        }    

        int i = 0;
        int k = 0;

        while(i < positive.size())
        {
            // Positive Added
            nums[k] = positive.get(i);
            k++;    

            // Negative Added
            nums[k] = negative.get(i);
            k++;

            i++;
        }

        return nums;
    }
}