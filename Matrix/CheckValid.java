class Solution {
    public boolean checkValid(int[][] matrix) {
        int n =matrix.length;
        
        for(int i = 0; i < n; i++)
        {
            Set<Integer> row = new HashSet<>();
            for(int j = 0; j < n; j++)
            {
                row.add(matrix[i][j]);
            }
            if(row.size() != n) return false;
        }

        for(int j = 0; j < n; j++)
        {
            Set<Integer> col = new HashSet<>();
            for(int i =0; i < n; i++)
            {
                col.add(matrix[i][j]);
            }
            if(col.size() != n) return false;
        }
        return true;
    }
}
