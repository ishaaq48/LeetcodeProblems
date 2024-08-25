/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean level = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> ds = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.remove();
                // Level to differentiate ZigZag True->L to R False-> R to L
                if (level) {
                    ds.add(curr.val);
                } else {
                    ds.add(0, curr.val);
                }
                // Adding current ele L and R
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }

            }
            ans.add(ds);
            level = !level;
        }
        return ans;
    }
}