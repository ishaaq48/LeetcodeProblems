class Solution {
    public int minJump(int ind, int[] nums, int n,int[] dp){
        if(ind >= n-1) return 0;
        if(nums[ind] == 0) return Integer.MAX_VALUE; 

        if(dp[ind] != -1) return dp[ind];
        int best = Integer.MAX_VALUE; 

        for(int i = 1; i <= nums[ind]; i++){
            int pick = minJump(ind+i,nums,n,dp);
            if(pick != Integer.MAX_VALUE) {
                best = Math.min(best,1 + pick);
            }
        }
        dp[ind] = best;
        return dp[ind];
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minJump(0,nums,n,dp);
    }
}