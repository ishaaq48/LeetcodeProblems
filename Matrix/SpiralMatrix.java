class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int total =row * col;
        int startRow = 0,startCol = 0;
        int endingRow = row-1,endingCol = col-1;

        while(count < total)
        {
            
            for(int i = startCol; count < total && i <= endingCol; i++)
            {
                ans.add(matrix[startRow][i]);
                count++;
            }
            startRow++;
            for(int i = startRow; count < total && i <= endingRow; i++)
            {
                ans.add(matrix[i][endingCol]);
                count++;
            }
            endingCol--;
            for(int i = endingCol; count < total && i >= startCol; i--)
            {
                ans.add(matrix[endingRow][i]);
                count++;
            }
            endingRow--;
            for(int i = endingRow; count < total && i >= startRow; i--)
            {
                ans.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }
        return ans;
    }
}
