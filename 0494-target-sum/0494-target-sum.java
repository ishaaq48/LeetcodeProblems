class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int n : nums)
            totalSum += n;

        int[] dp = new int[2 * totalSum + 1];

        dp[nums[0] + totalSum] = 1;
        dp[-nums[0] + totalSum] += 1;

        for(int i = 1; i < nums.length; i++) {
            int[]curr = new int[2 * totalSum + 1];
            for(int sum = -totalSum; sum <= totalSum; sum++) {
                if(dp[sum + totalSum] > 0) {
                    curr[sum + nums[i] + totalSum] += dp[sum + totalSum]; 
                    curr[sum - nums[i] + totalSum] += dp[sum + totalSum]; 
                }
            }
            dp = curr;
        }

        return Math.abs(target) > totalSum ? 0 : dp[target + totalSum];
    }
}