class Solution {

    public boolean dfs(int node,int parent,boolean[] vis, List<List<Integer>> adj){
        vis[node] = true;

        for(Integer it: adj.get(node)){
            if(vis[it] == false){
                if(dfs(it,node,vis,adj)) return true;
            }
            else if(parent != it) return true;
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        int m = edges[0].length;
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        int V = adj.size();
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            boolean[] vis = new boolean[V];
            if(dfs(u,-1,vis,adj) == true){
                return edge;
            }
        }
        return new int[0];
    }
}