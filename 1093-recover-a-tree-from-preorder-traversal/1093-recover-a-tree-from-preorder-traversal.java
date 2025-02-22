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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> st = new Stack<>();
        int i = 0;
        int n = traversal.length();

        while(i < n){
            int dashes = 0;

            while(i < n && traversal.charAt(i) == '-') {
                dashes++;
                i++;
            }

            int j = i;
            while(j < n && traversal.charAt(j) != '-'){
                j++;
            }

            int val = Integer.parseInt(traversal.substring(i,j));
            TreeNode node = new TreeNode(val);

            while(st.size() > dashes){
                st.pop();
            } 

            if(!st.isEmpty()) {
                if (st.peek().left == null) {
                    st.peek().left = node;
                } else {
                    st.peek().right = node;
                }
            }

            st.push(node);
            i = j;
        }

        return st.get(0);
    }
}