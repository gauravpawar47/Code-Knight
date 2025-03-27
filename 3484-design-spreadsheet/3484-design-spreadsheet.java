class Spreadsheet 
{
    HashMap<String, Integer> sheet;
    public Spreadsheet(int rows) 
    {
        sheet = new HashMap<>(); 
    }
    
    public void setCell(String cell, int value) 
    {   
        sheet.put(cell, value);
    }
    
    public void resetCell(String cell) 
    {
        sheet.remove(cell);    
    }
    
    public int getValue(String formula) 
    {
        if(!formula.startsWith("="))
        {
            return Integer.parseInt(formula);
        }    

        String[] tokens = formula.substring(1).split("\\+");
        int sum = 0;

        for(String token : tokens)
        {
            if(Character.isDigit(token.charAt(0)))
            {
                sum += Integer.parseInt(token);
            }
            else
            {
                sum += sheet.getOrDefault(token, 0);
            }
        }

        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */