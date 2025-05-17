class Solution 
{
    public class Node
    {
        Node[] child = new Node[26];
        boolean eow = false;
        List<String> anagrams = new ArrayList<>();

        public Node()
        {
            for(int i = 0; i < 26; i++)
            {
                child[i] = null;
            }
        }
    }

    public Node root = new Node();
    public void insert(String word)
    {
        char[] c = word.toCharArray();
        Arrays.sort(c);
        String sorted = new String(c);

        Node curr = root;
        for(int i = 0; i < sorted.length(); i++)
        {
            int idx = sorted.charAt(i) - 'a';
            if(curr.child[idx] == null)
            {
                curr.child[idx] = new Node();
            }

            curr = curr.child[idx];
        }

        curr.eow = true;
        curr.anagrams.add(word);
    }

    public void collectAnagrams(Node root, List<List<String>> result)
    {
        if(root == null)
        {
            return;
        }

        if(root.eow && !root.anagrams.isEmpty())
        {
            result.add(new ArrayList<>(root.anagrams));
        }

        for(int i = 0; i < 26; i++)
        {
            if(root.child[i] != null)
            {
                collectAnagrams(root.child[i], result);
            }
        }
    }

    public List<List<String>> groupAnagram(Node root, String[] arr)
    {
        for(String s : arr)
        {
            insert(s);
        }

        List<List<String>> result = new ArrayList<>();
        collectAnagrams(root, result);
        return result;
    }

    public List<List<String>> groupAnagrams(String[] str) 
    {
        List<List<String>> result = groupAnagram(root, str);        
        return result;
    }
}