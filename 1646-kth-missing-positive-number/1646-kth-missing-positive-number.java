class Solution 
{
    public int findKthPositive(int[] arr, int k) 
    {
        int expected = 1;   // Start checking from 1 (smallest positive number)
        int idx = 0;      // Pointer for arr[]
        
        while (k > 0) 
        {
            // If expected number is present in array, skip it
            if (idx < arr.length && arr[idx] == expected) 
            {
                idx++;
            } 
            else 
            {
                // Otherwise, it's missing
                k--;
            }

            // If we haven't found the kth missing, move to next number
            expected++;
        }
        
        // When k reaches 0, expected is 1 more than the answer
        return expected - 1;
    }
}