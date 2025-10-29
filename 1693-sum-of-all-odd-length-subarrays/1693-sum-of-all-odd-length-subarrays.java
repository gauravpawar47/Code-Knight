class Solution 
{
    public int sumOddLengthSubarrays(int[] arr) 
    {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int odd = 1;

        while(odd <= n)
        {
            list.add(odd);
            odd += 2;
        }   

        int resultSum = 0;
        for(int length : list)
        {
            for(int i = 0; i + length <= arr.length; i++)
            {
                int currSum = 0;
                for(int j = i; j < i + length; j++)
                {
                    currSum += arr[j];
                }

                resultSum += currSum;
            }
        }

        return resultSum;
    }
}