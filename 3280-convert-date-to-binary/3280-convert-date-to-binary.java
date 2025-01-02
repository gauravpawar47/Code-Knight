class Solution
{
    public String binary(String data)
    {
        int date = Integer.parseInt(data);
        return Integer.toBinaryString(date);
    }

    public String convertDateToBinary(String date)
    {
        String[] dates = date.split("-");
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < dates.length; i++)
        {
            sb.append(binary(dates[i]));
            if(i + 1 != dates.length)
            {
                sb.append("-");
            }    
        }      

        return sb.toString();
    }
}