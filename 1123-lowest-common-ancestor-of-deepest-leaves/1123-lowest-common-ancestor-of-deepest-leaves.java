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
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxDepth = 0;

    public void depth(TreeNode root, int depth)
    {
        // Step 1 : Base-Case
        if(root == null)
        {
            return;
        }

        maxDepth = Math.max(maxDepth, depth);
        map.put(root.val, depth);
        depth(root.left, depth + 1);
        depth(root.right, depth + 1);
    }

    public TreeNode LCA(TreeNode root)
    {
        if(root == null || map.getOrDefault(root.val, -1) == maxDepth)
        {
            return root;
        }

        TreeNode left = LCA(root.left);
        TreeNode right = LCA(root.right);

        if(left != null && right != null)
        {
            return root;
        }
        else
        {
            return left != null ? left : right;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        depth(root, 0);
        return LCA(root);
    }
}