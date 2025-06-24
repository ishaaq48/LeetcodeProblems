class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        int i = 0, j = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(i < n && j < m) {
            if(players[i] <= trainers[j]){
                i++;
            }
            j++;
        }

        return i;
    }
}