class Solution
{
    public int numOfSubarrays(int[] arr)
    {
        final int MOD = 1_000_000_007;
        int currSum = 0;
        int oddCount = 0;
        int evenCount = 1;

        int result = 0;
        for (int num : arr)
        {
            currSum += num;
            if(currSum % 2 == 0)
            {
                result = (result + oddCount) % MOD;
                evenCount++; 
            }
            else
            {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }

        return result;   
    }
}