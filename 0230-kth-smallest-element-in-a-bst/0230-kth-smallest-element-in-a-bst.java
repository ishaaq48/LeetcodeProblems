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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        int count = 0;

        while(node != null || !st.isEmpty()){
            while(node != null){
                st.push(node);
                node = node.left;
            }
            
            if(st.isEmpty()) break;
            node = st.pop();
            count++;
            if(count == k) return node.val;
            node = node.right;
        }

        return -1;
    }
}