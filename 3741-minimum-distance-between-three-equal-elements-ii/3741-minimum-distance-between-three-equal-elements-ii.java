class Solution 
{
    public int minimumDistance(int[] nums) 
    {
        int[] helper = nums;
        HashMap<Integer, Deque<Integer>> yantra = new HashMap<>();
        int minDis = Integer.MAX_VALUE;
        boolean isFound = false;

        for(int i = 0; i < helper.length; i++)
        {
            int temp = helper[i];
            yantra.putIfAbsent(temp, new ArrayDeque<>());
            Deque<Integer> dq = yantra.get(temp);

            dq.addLast(i);
            if(dq.size() > 3)
            {
                dq.removeFirst();
            }

            if(dq.size() == 3)
            {
                int first = dq.peekFirst();
                int last = dq.peekLast();
                int dist = 2 * (last - first);

                minDis = Math.min(minDis, dist);
                isFound = true;
            }
        }

        return isFound ? minDis : -1;
    }
}