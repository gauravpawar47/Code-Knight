class MyCalendarThree 
{
    TreeMap<Integer, Integer> timeline;
    int maxK;  // Stores the maximum overlap encountered

    public MyCalendarThree() 
    {
        timeline = new TreeMap<>();
        maxK = 0;
    }

    public int book(int start, int end) 
    {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int activeEvents = 0;
        for (int val : timeline.values()) 
        {
            activeEvents += val;
            maxK = Math.max(maxK, activeEvents);
        }
        
        return maxK;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
