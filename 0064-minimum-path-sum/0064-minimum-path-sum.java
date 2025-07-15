class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
       
        for(int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0){
                    temp[j] = grid[i][j];
                    continue;
                }
                    
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if(i > 0) 
                    up = dp[j]; // prev row val
                if(j > 0) 
                    left = temp[j-1]; // prev col val
                
                temp[j] = grid[i][j] + Math.min(up, left);
            }
            dp = temp;
        }

        return dp[m-1];
    }
}