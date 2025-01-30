class Solution {

    public boolean dfs(int node, int colour, int[] color, int[][] graph) {
        color[node] = colour;

        for (int it : graph[node]) {
            if (color[it] == -1) {
                if (dfs(it, 1 - colour, color, graph) == false) {
                    return false;
                }
            } else if (color[it] == color[node]) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false)
                    return false;
            }
        }

        return true;
    }
}