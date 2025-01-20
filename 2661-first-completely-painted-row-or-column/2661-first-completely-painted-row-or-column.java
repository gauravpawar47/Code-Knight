class Solution
{
    public int firstCompleteIndex(int[] arr, int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, Integer> map = new HashMap<>();    
        for(int i = 0; i < arr.length; i++)
        {
            map.put(arr[i], i);
        }

        int minIndex = Integer.MAX_VALUE;
        for(int row = 0; row < m; row++)
        {
            int lastIndex = Integer.MIN_VALUE;
            for(int col = 0; col < n; col++)
            {
                int val = mat[row][col];
                int idx = map.get(val);
                lastIndex = Math.max(lastIndex, idx);
            }

            minIndex = Math.min(minIndex, lastIndex);
        }

        for(int col = 0; col < n; col++)
        {
            int lastIndex = Integer.MIN_VALUE;
            for(int row = 0; row < m; row++)
            {
                int val = mat[row][col];
                int idx = map.get(val);
                lastIndex = Math.max(lastIndex, idx);
            }

            minIndex = Math.min(minIndex, lastIndex);
        }

        return minIndex;
    }
}