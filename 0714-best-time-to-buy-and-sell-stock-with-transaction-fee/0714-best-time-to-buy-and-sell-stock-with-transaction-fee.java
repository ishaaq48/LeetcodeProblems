class Solution {
    public int f(int ind, int buy, int fee,int[] prices,int n,int[][] dp){
        if(ind == n)
            return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1)
            profit = Math.max(-prices[ind]-fee + f(ind+1,0,fee,prices,n,dp), f(ind+1,1,fee,prices,n,dp));
        else 
            profit = Math.max(prices[ind] + f(ind+1,1,fee,prices,n,dp), f(ind+1,0,fee,prices,n,dp));

        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = 0; i <= n; i++)
        {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return f(0,1,fee, prices,n,dp);
    }
}