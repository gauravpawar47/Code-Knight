class Solution
{
    public int[] lexicographicallySmallestArray(int[] nums, int limit)
    {
        int n = nums.length;
        int[][] valueIndexPairs = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            valueIndexPairs[i][0] = nums[i];
            valueIndexPairs[i][1] = i;
        }   

        Arrays.sort(valueIndexPairs, (a, b) -> a[0] - b[0]);
        ArrayList<ArrayList<int[]>> groups = new ArrayList<>();
        ArrayList<int[]> current = new ArrayList<>();

        current.add(valueIndexPairs[0]);
        for(int i = 1; i < n; i++)
        {
            if(valueIndexPairs[i][0] - valueIndexPairs[i - 1][0] <= limit)
            {
                current.add(valueIndexPairs[i]);
            }
            else
            {
                groups.add(current);
                current = new ArrayList<>();
                current.add(valueIndexPairs[i]);
            }
        }

        groups.add(current);
        int[] result = new int[n];
        for(ArrayList<int[]> group : groups)
        {
            ArrayList<Integer> values = new ArrayList<>();
            ArrayList<Integer> index = new ArrayList<>();

            for(int[] pair : group)
            {
                values.add(pair[0]);
                index.add(pair[1]);
            }

            Collections.sort(index);
            for(int i = 0; i < index.size(); i++)
            {
                result[index.get(i)] = values.get(i);
            }
        }

        return result;
    }
}