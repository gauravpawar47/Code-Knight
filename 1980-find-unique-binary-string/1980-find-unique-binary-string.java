class Solution 
{
    int n;
    Set<String> numsSet = new HashSet();
    
    public String generate(String curr) 
    {
        if (curr.length() == n) 
        {
            return !numsSet.contains(curr) ? curr : "";
        }
        
        String addZero = generate(curr + "0");
        if (addZero.length() > 0) 
        {
            return addZero;
        }
        
        return generate(curr + "1");
    }
    
    public String findDifferentBinaryString(String[] nums) 
    {
        n = nums.length;
        for (String s : nums) 
        {
            numsSet.add(s);
        }
        
        return generate("");
    }
}