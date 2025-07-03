class Solution 
{
    public char kthCharacter(int k) 
    {
        // Step 1: Find the minimum level such that 2^level >= k
        int level = 0;
        while ((1 << level) < k) 
        {
            level++;
        }

        // Step 2: Start recursive helper to find k-th character at that level
        return helper(k, level);
    }

    public char helper(int k, int level) 
    {
        // Step 3: Base case — if at level 0, the string is just "a"
        if (level == 0)
        {
            return 'a';
        } 

        // Step 4: Calculate length of the first half at current level
        int half = 1 << (level - 1); 

        if (k <= half) 
        {
            // Step 5: If k is in the first half, it's same as in previous level
            return helper(k, level - 1);
        } 
        else 
        {
            // Step 6: If in second half, get character from previous level and shift it
            char ch = helper(k - half, level - 1);
            
            // Step 7: Shift character to next in alphabet
            return (char)(((ch - 'a' + 1) % 26) + 'a'); 
        }
    }
}