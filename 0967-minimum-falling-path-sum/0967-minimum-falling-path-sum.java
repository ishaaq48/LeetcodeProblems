class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++)
            dp[i] = matrix[n-1][i];

        for(int i = n-2; i >= 0; i--) {
            int[] curr = new int[n];
            for(int j = 0; j < m; j++){
                
                int down = matrix[i][j] + dp[j];
                int left = (j > 0) ? matrix[i][j] + dp[j-1] : Integer.MAX_VALUE;
                int right = (j < m-1) ? matrix[i][j] + dp[j+1] : Integer.MAX_VALUE;
                curr[j] = Math.min(down, Math.min(left, right));
                
            }
            dp = curr;
        }

        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            mini = Math.min(mini,dp[i]);
        }
        
        return mini;
    }
}