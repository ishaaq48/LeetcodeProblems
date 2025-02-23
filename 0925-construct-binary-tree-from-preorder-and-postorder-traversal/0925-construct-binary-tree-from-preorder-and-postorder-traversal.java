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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        Map<Integer,Integer> val_to_ind = new HashMap<>();

        for(int i = 0; i < n; i++){
            val_to_ind.put(postorder[i],i);
        }
        return build(0, n-1, 0,preorder,postorder, val_to_ind);
    }

    public TreeNode build(int i1,int i2,int j1,int[] preorder, 
    int[] postorder, Map<Integer,Integer> val_to_ind){
        if(i1 > i2)
            return null;

        TreeNode root = new TreeNode(preorder[i1]);
        if(i1 != i2){
            int left_val = preorder[i1 + 1];

            int mid = val_to_ind.get(left_val);

            int left_size = mid - j1 + 1;

            root.left = build(i1 + 1, i1 + left_size, j1,preorder,postorder,val_to_ind);
            root.right = build(i1 + left_size + 1, i2, mid+1,preorder,postorder,val_to_ind);

        }

        return root;
    }
}