public class Solution
{
    public static int lenLongestFibSubseq(int[] arr)
    {
        int n = arr.length;
        int maxLen = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Store index of each number in the array
        for (int i = 0; i < n; i++)
        {
            indexMap.put(arr[i], i);
        }

        // Iterate through all pairs (i, j)
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int x = arr[i], y = arr[j];
                int length = 2;  // Initial length of sequence

                // Try to extend the sequence
                while (indexMap.containsKey(x + y))
                {
                    int temp = y;
                    y = x + y;
                    x = temp;
                    length++;
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen > 2 ? maxLen : 0;  // Return 0 if no valid sequence found
    }
}
