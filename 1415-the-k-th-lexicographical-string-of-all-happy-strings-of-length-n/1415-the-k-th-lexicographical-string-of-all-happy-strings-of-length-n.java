public class Solution
{
    public String getHappyString(int n, int k)
    {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, "", happyStrings);
        
        return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
    }

    private void backtrack(int n, String curr, List<String> happyStrings)
    {
        if (curr.length() == n)
        {
            happyStrings.add(curr);
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'})
        {
            if (curr.isEmpty() || curr.charAt(curr.length() - 1) != ch)
            {
                backtrack(n, curr + ch, happyStrings);
            }
        }
    }
}