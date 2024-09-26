/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyCalendar
{
    ArrayList<int[]> events;
    public MyCalendar()
    {   
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end)
    {
        int[] newEvent = new int[]{start, end};

        for(int[] event : events)
        {
            if(newEvent[0] < event[1] && newEvent[1] > event[0])
            {
                return false;
            }
        }

        events.add(newEvent);

        Collections.sort(events, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

