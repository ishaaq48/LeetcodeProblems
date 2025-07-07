class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for(int[] dis : dist) Arrays.fill(dis, (int) 1e9);

        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, 0, 0});

        while(!pq.isEmpty()) {
            int[] tuple = pq.remove();
            int effort = tuple[0];
            int row = tuple[1];
            int col = tuple[2];

            if(n-1 == row && m-1 == col) return effort;
            for(int i = 0; i < 4; i++){
                int x = row + dx[i];
                int y = col + dy[i];

                if(x >= 0 && x < n && y >= 0 && y < m){
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[x][y]));
                    if(newEffort < dist[x][y]) {
                        dist[x][y] = newEffort;
                        pq.add(new int[]{dist[x][y], x, y});
                    }
                }
            }
        }

        return 0;
    }
}