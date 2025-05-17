class Solution 
{
    public static class Node
    {
        Node[] child = new Node[26];
        boolean eow = false;

        public Node()
        {
            for(int i = 0; i < 26; i++)
            {
                child[i] = null;
            }
        }
    }

    public static Node root;
    public static void insert(String key)
    {
        Node curr = root;
        for(int i = 0; i < key.length(); i++)
        {
            int idx = key.charAt(i) - 'a';
            if(curr.child[idx] == null)
            {
                curr.child[idx] = new Node();
            }

            curr = curr.child[idx];
        }

        curr.eow = true;
    }

    public static boolean isWordBreak(String s, int start, Boolean[] memo)
    {
        if(start == s.length())
        {
            return true;
        }

        if(memo[start] != null)
        {
            return memo[start];
        }

        Node curr = root;
        for(int i = start; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            if(curr.child[idx] == null)
            {
                break;
            }

            curr = curr.child[idx];
            if(curr.eow && isWordBreak(s, i + 1, memo))
            {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) 
    {
        root = new Node();
        for(String S : wordDict)
        {
            insert(S);
        }

        Boolean[] memo = new Boolean[s.length()];
        return isWordBreak(s, 0, memo);
    }
}