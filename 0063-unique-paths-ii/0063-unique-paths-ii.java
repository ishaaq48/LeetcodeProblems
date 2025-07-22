class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        return find(n,m,obstacleGrid);
    }

    public int find(int n, int m, int[][] grid){

        int[] prev = new int[m];
        for(int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                {
                    temp[j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int right = 0;
                if(i > 0)
                    up = prev[j];
                if(j > 0)
                    right = temp[j-1];

                temp[j] = up + right;
            }
            prev = temp;
        }

        return prev[m-1];
    }
} 