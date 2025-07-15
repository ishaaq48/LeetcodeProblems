class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        return find(0,0,m,n,dp);
    }
    public int find(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1) return 1;
        if(i == m || j == n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int right = find(i, j+1, m, n, dp); 
        int left = find(i+1, j, m, n, dp);

        return dp[i][j] = right + left; 
    }
}