class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // row and col check
        for(int i = 0; i < n; i++)
        {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] != '.')
                {
                    char c = board[i][j];
                    if(row.contains(c)) return false;
                    else
                    {
                        row.add(c);
                    }
                }
                if(board[j][i] != '.')
                {
                    char d = board[j][i];
                    if(col.contains(d)) return false;
                    else
                    {
                        col.add(d);
                    }
                }
            }
        }

        for (int row = 0; row < 9; row += 3) {  
    for (int col = 0; col < 9; col += 3) { 
        Set<Character> box = new HashSet<>();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[row + i][col + j];
                if (c != '.') {
                    if (box.contains(c)) {
                        return false;
                    }
                    box.add(c);
                }
            }
        }
    }
}
    return true;
    }
}
