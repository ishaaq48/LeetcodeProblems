class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public void bfs(int r, int c, boolean[][] vis, char[][] grid) {
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(r, c));
        int n = grid.length;
        int m = grid[0].length;
        int[] delR = { -1, 0, 1, 0 };
        int[] delC = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + delR[i];
                int ncol = col + delC[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == false && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }

        return cnt;
    }
}