class Solution
{
    public String longestCommonPrefix(String[] strs)
    {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();

        String first = strs[0];
        String last = strs[strs.length - 1];

        int minSize = Math.min(first.length(), last.length());
        for(int j = 0; j < minSize; j++)
        {
            if(first.charAt(j) == last.charAt(j))
            {
                sb.append(first.charAt(j));
            }
            else
            {
                break;
            }
        }

        return sb.toString();
    }
}