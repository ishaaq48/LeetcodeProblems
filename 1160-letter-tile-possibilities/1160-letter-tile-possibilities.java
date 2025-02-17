class Solution {
    int resCnt = 0;
    public int numTilePossibilities(String tiles) {
        
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        helper(arr,new boolean[arr.length]);
        return resCnt;
    }
    public void helper(char[] tiles, boolean[] visited){

        for(int i = 0; i < tiles.length;i++){
            if(visited[i] || (i > 0 && tiles[i] == tiles[i - 1] && !visited[i - 1])) continue;
            visited[i] = true;
            resCnt++;
            helper(tiles,visited);
            visited[i] = false;
        }

    }
}