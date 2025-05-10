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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int m = postorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = helper(postorder,0,m-1,0,n-1,inMap);

        return root;
    }

    public TreeNode helper(int[] postorder,int postStart,int postEnd,int inStart,int inEnd,Map<Integer, Integer> inMap){
        if(postStart > postEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(root.val);

        int numsLeft = inRoot - inStart;

        root.left = helper(postorder, postStart , postStart + numsLeft - 1, inStart, inRoot - 1, inMap);

        root.right = helper(postorder, postStart + numsLeft, postEnd - 1, inRoot + 1, inEnd,  inMap);

        return root;
    }
}