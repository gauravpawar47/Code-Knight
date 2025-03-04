class Solution 
{
    public boolean checkPowersOfThree(int n) 
    {
        return backtrack(n, 0, 0); 
    }

    public boolean backtrack(int n, int sum, int power) 
    {
        // Step 1: Base Case
        if (sum == n) 
        {
            return true;
        }
        
        if (sum > n || Math.pow(3, power) > n) 
        {
            return false;
        }

        // Step 2: Compute the current power of 3
        int currentPower = (int) Math.pow(3, power);

        // Step 3: Include the current power in the sum and move forward
        if (backtrack(n, sum + currentPower, power + 1)) 
        {
            return true;
        }

        // Step 4: Exclude the current power and move forward
        return backtrack(n, sum, power + 1);
    }
}