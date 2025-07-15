class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        Arrays.fill(prevRow, 1);

        for(int row = 1; row < m; row++) {
            int[] currRow = new int[n];
            Arrays.fill(currRow, 1);
            for(int col = 1; col < n; col++){
                currRow[col] = currRow[col-1] + prevRow[col]; 
            }
            prevRow = currRow;
        }

        return prevRow[n-1];
    }
}