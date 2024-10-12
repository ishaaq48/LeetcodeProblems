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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        preorderAdd(p,ans);
        preorderAdd(q,ans2);
        return ans.equals(ans2);
    }
    void preorderAdd(TreeNode p, List<Integer> ans)
    {
        if(p == null) 
        {
            ans.add(null);
            return;
        }

        ans.add(p.val);
        preorderAdd(p.left,ans);
        preorderAdd(p.right,ans);
    }
}
