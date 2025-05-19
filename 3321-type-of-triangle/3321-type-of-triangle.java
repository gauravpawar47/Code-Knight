class Solution 
{
    public String triangleType(int[] nums) 
    {
        int a = nums[0];    
        int b = nums[1];    
        int c = nums[2];    
    
        if(a + b <= c || a + c <= b || c + b <= a)
        {
            return "none";
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(a); 
        set.add(b); 
        set.add(c);

        return set.size() == 1 ? "equilateral" : (set.size() == 2 ? "isosceles" : "scalene"); 
    }
}