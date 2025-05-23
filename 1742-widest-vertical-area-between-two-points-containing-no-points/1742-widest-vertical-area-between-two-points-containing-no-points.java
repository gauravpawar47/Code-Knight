class Solution 
{
    public int maxWidthOfVerticalArea(int[][] points) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int[] point : points)
        {
            set.add(point[0]);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0; i < list.size() - 1; i++)
        {
            maxDiff = Math.max(maxDiff, Math.abs(list.get(i) - list.get(i + 1)));
        }

        return maxDiff == Integer.MIN_VALUE ? 0 : maxDiff;
    }
}