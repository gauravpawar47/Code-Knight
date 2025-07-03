class Solution 
{
    public boolean isSameAfterReversals(int num) 
    {
        String n = String.valueOf(num);
        // return n.length() == 2 ? false : true;
        return n.length() == 1 ? true : n.charAt(n.length() - 1) - '0' == 0 ? false : true;    
    }
}