class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return find(0, amount, coins, n, dp);
    }

    public int find(int i, int amount, int[] coins, int n, int[][] dp) {
        if(i == n) {
            if(amount == 0) 
                return 1;
            return 0;
        }

        if(dp[i][amount] != -1) return dp[i][amount];
        int pick = 0;

        if(coins[i] <= amount)
                pick = find(i,amount - coins[i], coins, n, dp);
        int notPick = find(i+1,amount, coins, n, dp);

        return dp[i][amount] = pick + notPick;
    }
}