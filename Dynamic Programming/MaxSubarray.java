class Solution {
    public int maxSubArray(int[] nums) {
        int sum =0,max=Integer.MIN_VALUE;
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        max = dp[0];
        for(int i = 1; i<nums.length; i++)
        { 
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1] );

            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
