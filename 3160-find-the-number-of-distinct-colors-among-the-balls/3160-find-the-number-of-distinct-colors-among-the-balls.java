class Solution
{
    public int[] queryResults(int limit, int[][] queries)
    {
        HashMap<Integer, Integer> ballColor = new HashMap<>(); // Ball → Color mapping
        HashMap<Integer, Integer> colorCount = new HashMap<>(); // Color → Count mapping
        HashSet<Integer> distinctColors = new HashSet<>(); // Tracks unique colors
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++)
        {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If ball already has a color, update colorCount
            if (ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                
                // Remove color if no ball has it
                if (colorCount.get(oldColor) == 0) {
                    distinctColors.remove(oldColor);
                }
            }

            // Assign new color to ball
            ballColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            // Store the current distinct color count
            result[i] = distinctColors.size();
        }
        return result;
    }
}
