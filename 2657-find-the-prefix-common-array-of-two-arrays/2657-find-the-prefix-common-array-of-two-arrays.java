class Solution
{
    public int[] findThePrefixCommonArray(int[] A, int[] B)
    {
        int n = A.length;
        int[] C = new int[n];
        Set<Integer> set = new HashSet<>();

        int commonCount = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(set.contains(A[i]))
            {
                commonCount++;
            }
            else
            {
                set.add(A[i]);
            }

            if(set.contains(B[i]))
            {
                commonCount++;
            }
            else
            {
                set.add(B[i]);
            }

            C[i] = commonCount;
        }

        return C;
    }
}