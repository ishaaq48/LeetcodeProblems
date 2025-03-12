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

class Tuple {
    TreeNode node;
    int vertice;
    int level;

    Tuple(TreeNode node, int vertice, int level){
        this.node = node;
        this.vertice = vertice;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple it = q.poll();
            TreeNode n = it.node;
            int v = it.vertice;
            int l = it.level;

            if(!map.containsKey(v))
                map.put(v, new TreeMap<>());
            if(!map.get(v).containsKey(l))
                map.get(v).put(l, new PriorityQueue<>());
            map.get(v).get(l).add(n.val);

            if(n.left != null)
                q.add(new Tuple(n.left,v - 1, l + 1));
            if(n.right != null)
                q.add(new Tuple(n.right,v + 1, l + 1));
        }


        for(Map<Integer, PriorityQueue<Integer>> ys : map.values()){
            List<Integer> ds = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : ys.values()) {
                while(!nodes.isEmpty())
                    ds.add(nodes.poll());
            }
            ans.add(ds);
        }



    return ans;

    }
}