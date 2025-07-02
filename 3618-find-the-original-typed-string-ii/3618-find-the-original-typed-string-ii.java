public class Solution 
{
    public static final int MOD = 1_000_000_007;
    public int possibleStringCount(String word, int k) 
    {
        // Step 1: Group consecutive letters
        List<Integer> groups = getConsecutiveLetters(word);

        // Step 2: Calculate total combinations (multiply each group length)
        long totalCombinations = 1;
        for (int group : groups) 
        {
            totalCombinations = (totalCombinations * group) % MOD;
        }

        // Step 3: Early exit if k <= number of groups
        if (k <= groups.size()) 
        {
            return (int) totalCombinations;
        }

        // Step 4: Initialize dp array
        int[] dp = new int[k];
        dp[0] = 1; // base case: one way to form an empty string

        // Step 5: DP over groups to count invalid combinations
        for (int i = 0; i < groups.size(); ++i) 
        {
            int[] newDp = new int[k];
            int group = groups.get(i);
            int windowSum = 0;

            for (int j = i; j < k; ++j) 
            {
                newDp[j] = (newDp[j] + windowSum) % MOD;
                windowSum = (windowSum + dp[j]) % MOD;

                if (j >= group) 
                {
                    windowSum = (windowSum - dp[j - group] + MOD) % MOD;
                }
            }

            dp = newDp;
        }

        // Step 6: Count all invalid combinations (lengths < k)
        int invalidCombinations = 0;
        for (int count : dp) 
        {
            invalidCombinations = (invalidCombinations + count) % MOD;
        }

        // Step 7: Subtract invalid from total to get valid combinations
        return (int) ((totalCombinations - invalidCombinations + MOD) % MOD);
    }

    public List<Integer> getConsecutiveLetters(String word) 
    {
        List<Integer> groups = new ArrayList<>();
        if (word.isEmpty())
        {
            return groups;
        } 

        int count = 1;
        for (int i = 1; i < word.length(); ++i) 
        {
            if (word.charAt(i) == word.charAt(i - 1)) 
            {
                count++;
            } 
            else 
            {
                groups.add(count);
                count = 1;
            }
        }

        groups.add(count);
        return groups;
    }
}