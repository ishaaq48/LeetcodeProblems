class Solution {
    public int f(int i, int j, int[][] grid, int n, int m, int[][] dp){
        if(i == n-1 && j == m-1)
            return grid[i][j];
        
        if(i >= n || j >= m)
            return Integer.MAX_VALUE;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        int down = f(i+1, j, grid, n, m, dp);
        int right = f(i, j+1, grid, n, m, dp);

        return dp[i][j] = grid[i][j] + Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                dp[i][j] = -1;
        } 

        return f(0,0,grid,n,m,dp);
    }
}