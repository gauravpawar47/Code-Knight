class Solution 
{
    public void getDigits(ArrayList<Integer> getNum, int num)
    {
        while(num > 0)
        {
            getNum.add(num % 10);
            num /= 10;
        }
    }

    public int countDigits(int num) 
    {
        if (num == 0)
        {
            return 1;
        } 

        ArrayList<Integer> getNum = new ArrayList<>();
        getDigits(getNum, num);
        int count = 0;

        for(int i = 0; i < getNum.size(); i++)
        {
            if(getNum.get(i) != 0 && num % getNum.get(i) == 0) 
            {
                count++;
            }
        }    

        return count;
    }
}
