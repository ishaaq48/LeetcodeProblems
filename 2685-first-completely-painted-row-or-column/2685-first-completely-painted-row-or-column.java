class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Map<Integer,int[]> posMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                posMap.put(mat[i][j], new int[]{i, j});
            }
        }
                
        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];

        for(int i =0; i < arr.length; i++){
            int num = arr[i];
            int[] position = posMap.get(num);
            int row = position[0];
            int col = position[1];

            rowCnt[row]++;
            colCnt[col]++;

            if(rowCnt[row] == m || colCnt[col] == n) return i;
        }

        return -1;
    }
}