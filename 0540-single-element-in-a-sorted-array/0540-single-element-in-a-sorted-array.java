class Solution 
{
    public int singleNonDuplicate(int[] nums) 
    {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) 
        {
            int mid = (left + right) / 2;

            // Check boundary cases first
            if ((mid == 0 || nums[mid] != nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) 
            {
                return nums[mid]; // Found the single element
            }

            // Now check how to move left or right
            // We want to eliminate one "pair + pair" segment

            // Case: mid is part of the left pair (first occurrence)
            if (mid > 0 && nums[mid] == nums[mid - 1]) 
            {
                // If number of elements from left to mid is odd, single is on the left
                int leftCount = mid - left + 1;
                if (leftCount % 2 == 1) 
                {
                    right = mid - 2; // move left
                } 
                else 
                {
                    left = mid + 1; // move right
                }
            }
            // Case: mid is part of the right pair (first occurrence)
            else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) 
            {
                int leftCount = mid - left;
                if (leftCount % 2 == 1) 
                {
                    right = mid - 1;
                } 
                else 
                {
                    left = mid + 2;
                }
            }
        }

        return -1; // Should never be reached if input is valid
    }
}