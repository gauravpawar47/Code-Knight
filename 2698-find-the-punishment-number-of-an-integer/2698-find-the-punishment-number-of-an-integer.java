class Solution
{
    // Function to check if n^2 can be partitioned into segments summing to n
    public static boolean canPartition(String num, int target, int start)
    {
        if (start == num.length())
        {
            return target == 0; // Successfully partitioned to sum to n
        }

        int sum = 0;
        for (int i = start; i < num.length(); i++)
        {
            sum = sum * 10 + (num.charAt(i) - '0'); // Form a number from substring
            if (sum > target)
            {
                break; // No need to continue if sum exceeds target
            }
            if (canPartition(num, target - sum, i + 1))
            {
                return true;
            }
        }
        return false;
    }

    // Function to check if n^2 can be partitioned into numbers summing to n
    public static boolean hasSubarraySum(int n)
    {
        int square = n * n;
        return canPartition(String.valueOf(square), n, 0);
    }

    // Function to calculate punishment number
    public int punishmentNumber(int n)
    {
        if (n == 0)
        {
            return 0; // Base case
        }

        int addValue = hasSubarraySum(n) ? (n * n) : 0;
        return addValue + punishmentNumber(n - 1);
    }
}
