class Solution
{
    public int finalValueAfterOperations(String[] operations) 
    {
        int a = 0;
        for(int i = 0; i < operations.length; i++)
        {
            
            if(operations[i].equals("++X") || operations[i].equals("X++"))
            {
                a += 1;
            }
            else if(operations[i].equals("X--") || operations[i].equals("--X"))
            {
                a -= 1;
            }
        }  

        return a;
    }
}