class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        int[][] dist = new int[n][n];

        for(int[] dis : dist) Arrays.fill(dis, (int) 1e9);
        dist[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1,0,0});

        while(!q.isEmpty()) {
            int[] tuple = q.remove();
            int distance = tuple[0];
            int row = tuple[1];
            int col = tuple[2];

            if(row == n - 1 && col == n - 1) return distance;
            for(int i = 0; i < 8; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && distance + 1 < dist[x][y]) {
                    dist[x][y] = distance + 1;
                    q.add(new int[] {1 + distance, x, y});
                }
            }
        }

        return -1;
    }
}