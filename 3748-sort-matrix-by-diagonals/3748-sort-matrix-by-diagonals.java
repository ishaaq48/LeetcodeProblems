class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                int key = r - c;
                map.putIfAbsent(key, key >= 0 ? 
                new PriorityQueue<>(Collections.reverseOrder()):
                new PriorityQueue<>()
                );
                map.get(key).offer(grid[r][c]);
            }
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                grid[r][c] = map.get(r-c).poll();
            }
        }

        return grid;
    }
}