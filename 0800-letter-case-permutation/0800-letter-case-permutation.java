class Solution 
{
    public void backtrack(String s, int i, StringBuilder sb ,List<String> result)
    {
        // Step 1 : Base-Case
        if(i == s.length())
        {
            result.add(sb.toString());
            return;
        }

        // Step 2 : Kaam
        char c = s.charAt(i);
        int len = sb.length();

        // Step 3 : Corner Case (Check For Digits)
        if(Character.isDigit(c))
        {
            sb.append(c);
            backtrack(s, i + 1, sb, result);
            sb.deleteCharAt(len);
        }
        else
        {
            // Step 4a : Lower Case (Inner Function Call)
            sb.append(Character.toLowerCase(c));
            backtrack(s, i + 1, sb, result);
            
            // Step 5a : Backtrack Step 
            sb.deleteCharAt(len);

            // Step 4b : Upper Case (Inner Function Call)
            sb.append(Character.toUpperCase(c));
            backtrack(s, i + 1, sb, result);
            
            // Step 5b : Backtrack Step 
            sb.deleteCharAt(len);
        }

    }

    public List<String> letterCasePermutation(String s) 
    {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);   
        return result;
    }
}