class Solution
{
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        int i = 0;

        // Step 1: Add all intervals that come before the newInterval
        while (i < n && intervals[i][1] < newInterval[0])
        {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add all intervals that come after the newInterval
        while (i < n)
        {
            result.add(intervals[i]);
            i++;
        }

        // Step 4: Convert result list to 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}