class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;

        int sr = 0;
        int sc = 0;
        int er = m - 1;
        int ec = n - 1;

        while(sr <= er && sc <= ec)
        {
            // Top View
            for(int j = sc; j <= ec; j++)
            {
                list.add(matrix[sr][j]);
            }

            // Right View
            for(int i = sr + 1; i <= er; i++)
            {
                list.add(matrix[i][ec]);
            }

            // Bottom View
            for(int j = ec - 1; j >= sc; j--)
            {
                if(sr == er)
                {
                    break;
                }

                list.add(matrix[er][j]);
            }

            // Left View
            for(int i = er - 1; i >= sr + 1; i--)
            {
                if(ec == sc)
                {
                    break;
                }

                list.add(matrix[i][sc]);
            }

            sc++;
            sr++;
            er--;
            ec--;
        }

        return list;    
    }
}