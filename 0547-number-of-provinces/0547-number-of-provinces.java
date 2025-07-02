class Solution {
    public void dfs(int node,List<List<Integer>> adj,boolean[] vis){
        vis[node] = true;
        
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
    
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int V = adj.size();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int cnt = 0;
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }

        return cnt;
    }
}