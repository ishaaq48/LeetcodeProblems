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

 class Pair{
    int vertice;
    TreeNode node;

    Pair(TreeNode node, int vertice){
        this.node = node;
        this.vertice = vertice;
    }
 }

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) 
            return 0;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            int first = 0,last = 0;
            int min = q.peek().vertice;

            for(int i = 0; i < size; i++){

                int idx = q.peek().vertice - min;
                TreeNode node = q.peek().node;

                q.poll();

                if(i == 0)
                    first = idx;
                if(i == size-1)
                    last = idx;

                if(node.left != null)
                    q.add(new Pair(node.left, idx * 2 + 1));
                if(node.right != null)
                    q.add(new Pair(node.right, idx * 2 + 2));
            }

            ans = Math.max(ans, last - first + 1);

        }

        return ans;
    }
}