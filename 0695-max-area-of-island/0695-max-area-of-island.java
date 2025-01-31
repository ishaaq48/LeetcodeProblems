class Solution {

    public int dfs(int i, int j, int[][] vis,int[][] grid){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 0;
        }
        if(vis[i][j] == 1 || grid[i][j] == 0){
            return 0; 
        }
        vis[i][j] = 1;
        int currArea = 1;
        
        currArea += dfs(i+1,j,vis,grid);
        currArea += dfs(i-1,j,vis,grid);
        currArea += dfs(i,j+1,vis,grid);
        currArea += dfs(i,j-1,vis,grid);

        return currArea;
    }

    public int maxAreaOfIsland(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int[][] vis = new int[n][m]; 
       int maxArea = 0;

       for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(vis[i][j] == 0 && grid[i][j] == 1){
                int result = dfs(i,j,vis,grid);
                maxArea = Math.max(maxArea,result); 
            }
        }
       } 

       return maxArea;
    }
}