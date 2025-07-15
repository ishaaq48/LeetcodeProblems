class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d, -1);
        return find(0,0,n,m,dp,obstacleGrid);
    }

    public int find(int i, int j, int n, int m, int[][]dp, int[][] grid){
        if(i == n-1 && j == m-1 && grid[i][j] == 0) return 1;
        if(i == n || j == m) return 0;
        if(grid[i][j] == 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int down = find(i+1,j,n,m,dp,grid);
        int right = find(i,j+1,n,m,dp,grid);

        return dp[i][j] = down + right;
    }
} 