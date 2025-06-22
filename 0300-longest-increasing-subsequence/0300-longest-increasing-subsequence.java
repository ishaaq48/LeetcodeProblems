class Solution {
    public int f(int ind, int prev,int[] nums,int n,int[][] dp){
        if(ind == n)
            return 0;

        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];

        int not_take = f(ind+1,prev,nums,n,dp);
        int take = 0;
        if(prev == -1 || nums[ind] > nums[prev]){
            take = 1 + f(ind + 1, ind,nums,n,dp);
        }

        return dp[ind][prev+1] = Math.max(take,not_take);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(0,-1,nums,n,dp);
    }
}