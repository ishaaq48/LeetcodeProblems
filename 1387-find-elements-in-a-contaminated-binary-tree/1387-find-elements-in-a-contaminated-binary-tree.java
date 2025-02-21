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
class FindElements {
    Set<Integer> set = new HashSet<>();

    public void recover(TreeNode root, int x) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        root.val= 0;
        q.add(root);
        set.add(0);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.left != null) {
                node.left.val = 2 * node.val + 1;
                set.add(node.left.val);
                q.add(node.left);
            }

            if (node.right != null) {
                node.right.val = 2 * node.val + 2;
                set.add(node.right.val);
                q.add(node.right);
            }
        }

    }

    public FindElements(TreeNode root) {
        if (root != null)
            recover(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */