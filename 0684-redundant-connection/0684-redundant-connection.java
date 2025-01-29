class Solution {
    public int find(int x,int[] parent){
        if(parent[x] != x){
            parent[x] = find(parent[x],parent);
        }

        return parent[x];
    }
    public boolean union(int u, int v,int[] parent){
        int rootU = find(u,parent);
        int rootV = find(v,parent);

        if(rootU == rootV) return false;

        parent[rootU] = rootV;
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            if(!union(edge[0], edge[1],parent)) return edge;
        }

        return new int[0];
    }
}