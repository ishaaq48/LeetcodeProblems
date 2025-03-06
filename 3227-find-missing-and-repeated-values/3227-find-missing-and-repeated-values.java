class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int row_col_len = n * m;
        int total_sum = row_col_len*(row_col_len + 1) / 2;
        int actual_sum = 0;
        Set<Integer> set = new HashSet<>();
        int repeat_num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                actual_sum += grid[i][j];
                if(set.contains(grid[i][j])){
                    repeat_num = grid[i][j];
                }
                set.add(grid[i][j]);
                
            }
        } 

     

        int missing_num = total_sum - (actual_sum - repeat_num);

        return new int[]{repeat_num,missing_num};
    }
}