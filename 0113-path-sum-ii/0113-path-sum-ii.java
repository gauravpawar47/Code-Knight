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
    public void backtrack(TreeNode node, int target, List<List<Integer>> result, List<Integer> path)
    {
        // Step 1 : Base-Case
        if(node == null)
        {
            return;
        }

        // Step 2 : Kaam
        path.add(node.val);

        if(node.left == null && node.right == null && target == node.val)
        {
            result.add(new ArrayList<>(path));
        }
        else
        {
            // Step 3 : Inner Function Call

            backtrack(node.left, target - node.val, result, path);
            backtrack(node.right, target - node.val, result, path);
        }

        // Step 4 : Backtrack Step
        path.remove(path.size() - 1);
    } 

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, targetSum, result, new ArrayList<>());
        return result;
    }
}