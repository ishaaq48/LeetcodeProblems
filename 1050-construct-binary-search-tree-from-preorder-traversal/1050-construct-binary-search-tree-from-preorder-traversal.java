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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,Integer.MAX_VALUE);
    }
    public TreeNode bst(int[] preorder,int upperBound) {
        if(index == preorder.length || preorder[index] > upperBound) return null;

        int val = preorder[index++];
        TreeNode node = new TreeNode(val);

        node.left = bst(preorder, val);
        node.right = bst(preorder, upperBound);

        return node;
    }
}