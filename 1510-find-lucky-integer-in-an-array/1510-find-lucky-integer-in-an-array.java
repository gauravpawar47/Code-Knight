class Solution 
{
    public int findLucky(int[] arr) 
    {
        // Step 1: Initialize a frequency map of size 501
        int[] map = new int[501];

        // Step 2: Count how many times each number appears
        for (int n : arr) 
        {
            map[n]++;
        }

        // Step 3: Search from 500 down to 1 for the largest lucky number
        for (int i = 500; i > 0; i--) 
        {
            if (map[i] == i) 
            {
                return i; // Found a lucky number
            }
        }

        // Step 4: Return -1 if no lucky number is found
        return -1;
    }
}