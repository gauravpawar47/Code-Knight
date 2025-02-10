class Solution
{
    public String clearDigits(String s)
    {
        StringBuilder sb= new StringBuilder(s);
        int i=0;
    
        while(i < sb.length())
        {
            if(Character.isDigit(sb.charAt(i)))
            {
                if(i == 0)
                {
                    sb.deleteCharAt(i);
                }
                if(i == sb.length() - 1)
                {
                    sb.deleteCharAt(i); 
                }
                if(i > 0)
                {
                    sb.delete(i - 1,i + 1);
                    i--;
                }    
            }
            else
            {
                i++;
            } 
        }
        return sb.toString();
    }
}