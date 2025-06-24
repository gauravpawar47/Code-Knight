class Solution 
{
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) 
    {
        // Step 1: Initialize a list to store indices where nums[i] == key
        List<Integer> keyIndices = new ArrayList<>();

        // Step 1: Traverse the array to find all positions of the key
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] == key) 
            {
                keyIndices.add(i);  // Save the index of the key
            }
        }

        // Step 2: Initialize result list to store k-distant indices
        List<Integer> result = new ArrayList<>();

        // Step 2: For each index in the array
        for (int i = 0; i < nums.length; i++) 
        {
            // Check if this index is within distance k of any key index
            for (int j : keyIndices) 
            {
                if (Math.abs(i - j) <= k) 
                {
                    // Step 2: Valid index found, add it
                    result.add(i);  
                    break;  // No need to check more key indices for this i
                }
            }
        }

        // Step 3: Return the list of k-distant indices
        return result;
    }
}