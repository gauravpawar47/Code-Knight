class Solution
{
    public int[][] merge(int[][] intervals)
    {
        // Step 0 : Base-Case
        if (intervals.length <= 1)
        {
            return intervals;
        }

        // Step 1: Sort the intervals by their starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize result list
        List<int[]> result = new ArrayList<>();

        // Step 3: Start merging intervals
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int i = 1; i < intervals.length; i++)
        {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Step 4 : Check if there is an overlap
            if (currentEnd >= nextStart)
            {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else
            {
                currentInterval = intervals[i];
                result.add(currentInterval);
            }
        }

        // Step 5: Convert result list to 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}