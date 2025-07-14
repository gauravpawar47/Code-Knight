class Solution 
{
    public void nextPermutation(int[] nums) 
    {
        int pivot = -1;
        int n = nums.length;

        // Step 1: Find the pivot: the first number from the end where nums[i] < nums[i + 1]
        for (int i = n - 2; i >= 0; i--) 
        {
            if (nums[i] < nums[i + 1]) 
            {
                pivot = i;
                break;
            }
        }

        // If no pivot is found, the array is in descending order
        if (pivot == -1) 
        {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the successor: the smallest number greater than pivot, scanning from the end
        int successor = -1;
        for (int j = n - 1; j > pivot; j--) 
        {
            if (nums[j] > nums[pivot]) 
            {
                successor = j;
                break;
            }
        }

        // Step 3: Swap pivot and successor
        swap(nums, pivot, successor);

        // Step 4: Reverse the suffix starting at pivot + 1
        reverse(nums, pivot + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) 
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) 
    {
        while (start < end) 
        {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}