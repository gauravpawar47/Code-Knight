/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(root, sb, result);
        return result;    
    }

    public void backtrack(TreeNode root, StringBuilder path, List<String> result)
    {
        // Step 1 : Base-Case
        if(root == null)
        {
            return;
        }

        // Step 2 : Kaam 
        int n = path.length();
        if(path.length() > 0)
        {
            path.append("->");
        }

        path.append(root.val);

        // Step 3 : Inner Function Call
        if(root.left == null && root.right == null)
        {
            result.add(path.toString());
        }
        else
        {
            backtrack(root.left, path, result);
            backtrack(root.right, path, result);
        }

        // Step 4 : Backtrack Step
        path.setLength(n);
    }
}