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
class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.right == null && root.left == null) 
        {
            return targetSum == root.val;
        }

        int ans = targetSum - root.val;

        return hasPathSum(root.left,ans) || hasPathSum(root.right,ans);
    }
}