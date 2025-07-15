class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= numRows; i++)
        {
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j = 1; j <= i; j++)
            {
                if(j == 1 || j == i)
                {
                    curr.add(1);
                }
                else
                {
                    int left = result.get(i - 2).get(j - 2);
                    int right = result.get(i - 2).get(j - 1);
                    curr.add(left + right);
                }
            }

            result.add(curr);
        }    

        return result;
    }
}