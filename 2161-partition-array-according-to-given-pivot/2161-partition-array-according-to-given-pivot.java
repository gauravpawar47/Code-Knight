class Solution 
{
    public int[] pivotArray(int[] nums, int pivot) 
    {
        ArrayList<Integer> before = new ArrayList<>();
        ArrayList<Integer> after  = new ArrayList<>();

        int pivotCount = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == pivot)
            {
                pivotCount++;
                continue;
            }

            if(nums[i] < pivot)
            {
                before.add(nums[i]);
            }
            else if(nums[i] > pivot)
            {
                after.add(nums[i]);
            }
        }

        int j = 0;
        for(int i = 0; i < before.size(); i++)
        {
            nums[j] = before.get(i);
            j++;
        }

        while(pivotCount > 0)
        {
            nums[j] = pivot;
            pivotCount--;
            j++;
        }

        for(int i = 0; i < after.size(); i++)
        {
            nums[j] = after.get(i);
            j++;
        }

        return nums;
    }
}