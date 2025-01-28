class Solution {    
    public boolean dfs(int node,List<List<Integer>> adj,boolean[] vis,
    boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;

        for(Integer it: adj.get(node)){
            if(vis[it] == false){
                if(dfs(it,adj,vis,pathVis)) return true;
            }else if(pathVis[it] == true){
                return true;
            }
        }

        pathVis[node] = false;
        return false; 
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) 
        {
            int course = pair[0];
            int prerequisite = pair[1];
            adj.get(prerequisite).add(course); 
        }
        
        int V = adj.size();
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(dfs(i, adj, vis, pathVis) == true) return false;
            }
        }
        
        return true;
    }
}