class Solution
{
    public int[][] sortTheStudents(int[][] score, int k)
    {
        int m = score.length;
        int n = score[0].length;

        Arrays.sort(score, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                // Compare based on the k-th score
                return Integer.compare(b[k], a[k]); // descending order (highest score first)
            }
        });

        return score;
    }
}