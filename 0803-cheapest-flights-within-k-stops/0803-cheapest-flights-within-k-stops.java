class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int price = edge[2];

            adj.get(u).add(new int[] {v, price});
        }

        int[][] dist = new int[n][k + 2]; 
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[] {0, src, 0});

        while(!pq.isEmpty()) {
            int[] tuple = pq.remove();
            int distance = tuple[0];
            int node = tuple[1];
            int stops = tuple[2];

            if(node == dst) return distance;
            if (stops > k) continue;

            for(int[] it : adj.get(node)){
                int price = it[1];
                int adjNode = it[0];
                if(distance + price < dist[adjNode][stops+1]){
                    dist[adjNode][stops+1] = distance + price; 
                    pq.add(new int[] {distance + price, adjNode, stops+1});
                }
            } 
        }

        return -1;
    }
}