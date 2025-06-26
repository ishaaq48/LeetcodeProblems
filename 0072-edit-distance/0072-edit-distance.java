class Solution {
    public int f(int i, int j, String w1, String w2, int n, int m, int[][] dp){
        if(i == n) return m - j;
        if(j == m) return n - i;

        if(dp[i][j] != -1) return dp[i][j];
        int maxi = 0;
        if(w1.charAt(i) == w2.charAt(j)){
            return f(i+1,j+1,w1,w2,n,m,dp);
        } 
        int insert = 1 + f(i,j+1,w1,w2,n,m,dp);
        int delete = 1 + f(i+1,j,w1,w2,n,m,dp);
        int replace = 1 + f(i+1,j+1,w1,w2,n,m,dp);
        
        maxi = Math.min(Math.min(insert, delete), replace);
        return dp[i][j] = maxi;
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++) 
                dp[i][j] = -1;
        }
        return f(0, 0, word1, word2, n, m, dp);
    }
}