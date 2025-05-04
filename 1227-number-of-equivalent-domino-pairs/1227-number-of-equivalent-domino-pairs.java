class Solution 
{
    public int numEquivDominoPairs(int[][] dominoes) 
    {
        // Step 1: Frequency array
        int[] count = new int[100];  
        
        // Step 2: Result counter
        int result = 0;              

        // Step 3: Loop through each domino
        for (int[] d : dominoes) 
        {   
            int a = d[0], b = d[1];
        
            // Step 4: Normalize
            int key = a < b ? a * 10 + b : b * 10 + a;  

            // Step 5: Add number of seen pairs
            result += count[key];  
            
            // Step 6: Track the current domino
            count[key]++;          
        }

        // Step 7: Return the answer
        return result; 
    }
}