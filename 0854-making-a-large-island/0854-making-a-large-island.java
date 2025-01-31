class Solution {
public int dfs(int i, int j, int[][] grid, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = id; 
        int area = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            area += dfs(i + dr[k], j + dc[k], grid, id);
        }

        return area;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Map<Integer, Integer> island = new HashMap<>();
        int islandId = 2;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, grid, islandId);
                    island.put(islandId, size);
                    maxArea = Math.max(size, maxArea);
                    islandId++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {
                    Set<Integer> seenIsland = new HashSet<>();
                    int newSize = 1;
                    int[] delR = { -1, 0, 1, 0 };
                    int[] delC = { 0, 1, 0, -1 };

                    for (int k = 0; k < 4; k++) {
                        int nrow = i + delR[k];
                        int ncol = j + delC[k];
                        if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] > 1) {
                            int id = grid[nrow][ncol];
                            if (!seenIsland.contains(id)) {
                                newSize += island.get(id);
                                seenIsland.add(id);
                            }
                        }

                    }
                    maxArea = Math.max(maxArea, newSize);
                }

            }
        }

        return maxArea == 0 ? n * m : maxArea;
    }
}