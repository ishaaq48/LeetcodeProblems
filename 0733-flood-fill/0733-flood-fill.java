class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        q.add(new int[] { sr, sc });
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int j = 0; j < 4; j++) {
                int x = point[0] + dx[j];
                int y = point[1] + dy[j];
                if (x >= 0 && y >= 0 && x < n && y < m && image[x][y] == oldColor) {
                    image[x][y] = color;
                    q.add(new int[] { x, y });
                }
            }
        }

        return image;
    }
}