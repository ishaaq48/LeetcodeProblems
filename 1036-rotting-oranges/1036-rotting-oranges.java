class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int cntFresh = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) 
                    q.add(new int[] {i, j});
                
                if(grid[i][j] == 1)
                    cntFresh++;
            }
        }

        if(cntFresh == 0) return 0;
        int cntMin = 0, cnt = 0;
        int[] dx = {0, 0, 1, -1}; 
        int[] dy = {1, -1, 0, 0};

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                for(int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) 
                        continue;
                    
                    grid[x][y] = 2;
                    cnt++;
                    q.add(new int[] {x, y});
                }
            }
            if(!q.isEmpty())
                cntMin++;
        }

        return cntFresh == cnt ? cntMin : -1;
    }
}