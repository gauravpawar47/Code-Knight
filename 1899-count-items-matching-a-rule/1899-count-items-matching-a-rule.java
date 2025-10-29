class Solution 
{
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) 
    {
        int idx = ruleKey.equals("color") ? 1 : (ruleKey.equals("type") ? 0 : 2);
        int count = 0;

        for(List<String> item : items)
        {
            if(item.get(idx).equals(ruleValue))
            {
                count++;
            }
        }

        return count;
    }
}