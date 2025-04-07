class Solution 
{
    static class Job
    {
        int startTime;
        int endTime;
        int profit;

        Job(int startTime, int endTime, int profit)
        {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }    
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) 
    {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for(int i = 0; i < n; i++)
        {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(j -> j.endTime));
        TreeMap<Integer, Integer> dp = new TreeMap<>();

        dp.put(0, 0);
        for(Job job : jobs)
        {
            Integer prevProfit = dp.floorEntry(job.startTime).getValue();
            int currProfit = prevProfit + job.profit;

            if(currProfit > dp.lastEntry().getValue())
            {
                dp.put(job.endTime, currProfit);
            }
        }

        return dp.lastEntry().getValue();
    }
}