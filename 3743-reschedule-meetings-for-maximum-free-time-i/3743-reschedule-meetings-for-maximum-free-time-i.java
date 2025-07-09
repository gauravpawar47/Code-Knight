class Solution 
{
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) 
    {
        // Step 1: Store gaps
        int n = startTime.length;
        int[] gaps = new int[n + 1]; 

        // gap before the first meeting
        gaps[0] = startTime[0];
        
        // gaps between meetings
        for (int i = 1; i < n; ++i) 
        {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        
        // gap after the last meeting
        gaps[n] = eventTime - endTime[n - 1];

        // Step 2: Sliding window to find max sum of k + 1 consecutive gaps
        int windowSum = 0;
        int maxFree = 0;
        for (int i = 0; i <= n; ++i) 
        {
            windowSum += gaps[i];
            if (i >= k) 
            {
                maxFree = Math.max(maxFree, windowSum);
                windowSum -= gaps[i - k]; // Slide window
            }
        }

        return maxFree;
    }
}