class Solution
{
    public String findDifferentBinaryString(String[] nums)
    {
        Set<String> set = new HashSet<>();
        for (String num : nums)
        {
            set.add(num);
        }

        return backtrack(set, new StringBuilder(), nums.length);
    }

    private String backtrack(Set<String> set, StringBuilder sb, int n)
    {
        if (sb.length() == n)
        {
            String candidate = sb.toString();
            if (!set.contains(candidate))
            {
                return candidate;
            }

            return null;
        }

        sb.append('0');
        String result = backtrack(set, sb, n);
        if (result != null) 
        {
            return result;
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        result = backtrack(set, sb, n);
        if (result != null) 
        {
            return result;
        }
        sb.deleteCharAt(sb.length() - 1);

        return null;
    }
}