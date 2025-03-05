class Solution 
{
    public int[] countPoints(int[][] points, int[][] queries) 
    {
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++)
        {
            int point = 0;
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];

            for(int j = 0; j < points.length; j++)
            {
                int xPoint = points[j][0];   
                int yPoint = points[j][1];

                int dx = xPoint - x;
                int dy = yPoint - y;
                int distance = dx * dx + dy * dy;

                if(distance <= r * r)
                {
                    point++;
                }
            }

            result[i] = point;
        }
        
        return result;
    }
}