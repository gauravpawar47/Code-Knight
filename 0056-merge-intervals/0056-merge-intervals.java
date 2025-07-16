class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        if(intervals == null || intervals.length == 0)
        {
            return new int[0][0];
        }

        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++)
        {
            int[] curr = intervals[i];
            int[] prev = result.get(result.size() - 1);

            int prevEnd = prev[1];
            int currStart = curr[0];

            if(prevEnd >= currStart)
            {
                int[] merged = new int[2];
                merged[0] = prev[0];
                merged[1] = Math.max(prev[1], curr[1]);

                result.set(result.size() - 1, merged);
            }
            else
            {
                result.add(curr);    
            }
        }   

        return result.toArray(new int[result.size()][]);
    }
}