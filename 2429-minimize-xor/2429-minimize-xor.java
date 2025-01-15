class Solution
{
    public int minimizeXor(int num1, int num2)
    {
        int targetBitCount = Integer.bitCount(num2);
        int result = 0;

        // Step 1: Set bits in result based on num1
        for (int i = 31; i >= 0 && targetBitCount > 0; i--)
        {
            if ((num1 & (1 << i)) != 0)
            {
                result |= (1 << i);
                targetBitCount--;
            }
        }

        // Step 2: Set remaining bits (lowest unset bits) if targetBitCount > 0
        for (int i = 0; i < 32 && targetBitCount > 0; i++)
        {
            if ((result & (1 << i)) == 0)
            {
                result |= (1 << i);
                targetBitCount--;
            }
        }

        return result;
    }
}