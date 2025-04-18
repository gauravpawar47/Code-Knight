class Solution
{
    public int minBitFlips(int start, int goal)
    {
        // XOR the start and goal numbers
        int xor = start ^ goal;
        int count = 0;

        // Count the number of 1s in the XOR result (each 1 represents a differing bit)
        while (xor > 0)
        {
            count += xor & 1;  // Add 1 to count if the last bit is 1
            xor >>= 1;         // Shift the XOR result to the right by 1 bit
        }

        return count;
    }
}
