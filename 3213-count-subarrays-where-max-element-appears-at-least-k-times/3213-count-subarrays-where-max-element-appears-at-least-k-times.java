public class Solution 
{
    public long countSubarrays(int[] nums, int k) 
    {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) 
        {
            maxVal = Math.max(maxVal, num);
        }

        long result = 0;
        int left = 0;
        int countMax = 0;

        for (int right = 0; right < nums.length; right++) 
        {
            if (nums[right] == maxVal) 
            {
                countMax++;
            }

            while (countMax >= k) 
            {
                if (nums[left] == maxVal) 
                {
                    countMax--;
                }
                
                left++;
            }

            result += left;
        }

        return result;
    }
}