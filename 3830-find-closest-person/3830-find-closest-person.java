class Solution 
{
    public int findClosest(int x, int y, int z) 
    {
        int diff1 = Math.abs(x - z);
        int diff2 = Math.abs(y - z);

        return diff1 == diff2 ? 0 : (diff1 > diff2 ? 2 : 1);
    }
}