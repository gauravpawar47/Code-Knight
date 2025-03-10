class Solution 
{
    public int countVowelStrings(int n) 
    {
        return (int) ((long)(n + 4) * (n + 3) * (n + 2) * (n + 1) / 24);
    }
}