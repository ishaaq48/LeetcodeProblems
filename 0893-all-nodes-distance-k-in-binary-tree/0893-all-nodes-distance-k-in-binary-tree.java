/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();

            if (parent.left != null) {
                q.add(parent.left);
                adj.computeIfAbsent(parent, x -> new ArrayList<>()).add(parent.left);
                adj.computeIfAbsent(parent.left, x -> new ArrayList<>()).add(parent);
            }
            if (parent.right != null) {
                q.add(parent.right);
                adj.computeIfAbsent(parent, x -> new ArrayList<>()).add(parent.right);
                adj.computeIfAbsent(parent.right, x -> new ArrayList<>()).add(parent);
            }
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        bfs.add(target);
        visited.add(target);
        int distance = 0;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            if(distance == k) {
                for(int i = 0; i < size; i++) {
                    result.add(bfs.poll().val);
                }
                return result;
            }
            
            for(int i = 0; i < size; i++){
                TreeNode curr = bfs.poll();
                for(TreeNode it : adj.getOrDefault(curr, new ArrayList<>())){
                    if(!visited.contains(it)){
                        visited.add(it);
                        bfs.add(it);
                    }
                }
            }
            distance++;
        }

        return result;
    }
}