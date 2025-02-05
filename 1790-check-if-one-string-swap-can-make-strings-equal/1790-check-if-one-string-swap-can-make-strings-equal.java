class Solution
{
    public boolean areAlmostEqual(String s1, String s2)
    {
        if (s1.equals(s2)) return true;
        int n = s1.length();
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {  
                char[] arr = s2.toCharArray();
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                if (s1.equals(new String(arr)))
                {
                    return true;
                }
            }
        }
        
        return false; 
    }
}