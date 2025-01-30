class Solution {
    public int bfs(int start, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
        }
        return level;
    }

    public int getMaxDepth(Set<Integer> component, List<List<Integer>> graph) {
        int maxDepth = 0;


        for (int node : component) {
            maxDepth = Math.max(maxDepth, bfs(node, graph));
        }
        return maxDepth;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

 
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        int maxGroup = 0;


        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                Set<Integer> component = new HashSet<>();
                if (!isBipartite(i, color, adj, component)) {
                    return -1; 
                }
                maxGroup += getMaxDepth(component, adj);
            }
        }
        return maxGroup;
    }

    public boolean isBipartite(int start, int[] color, List<List<Integer>> graph, Set<Integer> component) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            component.add(node);

            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; 
                }
            }
        }
        return true;
    }
}