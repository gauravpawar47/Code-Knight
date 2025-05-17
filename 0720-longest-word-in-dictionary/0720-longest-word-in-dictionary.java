class Solution 
{
    public class Node
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

    public Node root = new Node();
    public void insert(String word)
    {
        Node curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null)
            {
                curr.child[idx] = new Node();
            }
            
            curr = curr.child[idx];
        }

        curr.eow = true;
    }


    public String result = "";
    public void largestWord(Node root, StringBuilder temp)
    {
        if(root == null)
        {
            return;
        }

        for(int i = 0; i < 26; i++)
        {
            if(root.child[i] != null && root.child[i].eow)
            {
                temp.append((char) (i + 'a'));
                if(temp.length() > result.length())
                {
                    result = temp.toString();
                }

                largestWord(root.child[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }

        }
    }

    public String longestWord(String[] words) 
    {
        for(String s : words)
        {
            insert(s);
        }

        largestWord(root, new StringBuilder(""));
        return result;
    }
}