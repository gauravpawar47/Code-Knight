class Solution
{
    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        int pivot = -1;

        // Step 1: Find the pivot
        for (int i = n - 2; i >= 0; i--)
        {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If no pivot is found, reverse the entire array
        if (pivot == -1)
        {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the swap candidate
        int swap = -1;
        for (int j = n - 1; j > pivot; j--)
        {
            if (nums[j] > nums[pivot])
            {
                swap = j;
                break;
            }
        }

        // Step 4: Swap the pivot and swap candidate
        swap(nums, pivot, swap);

        // Step 5: Reverse the subarray after the pivot
        reverse(nums, pivot + 1, n - 1);
    }

    // Helper function to swap two elements in the array
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse a subarray
    private void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}