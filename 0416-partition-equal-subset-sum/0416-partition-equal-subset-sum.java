class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for(int num : nums)
            totalSum += num;
        
        if(totalSum % 2 != 0) return false;

        int halfSum = totalSum / 2;
        boolean[] prev = new boolean[halfSum+1];

        prev[0] = true;
        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[halfSum+1];
            curr[0] = true;
            for(int j = 1; j <= halfSum; j++) {
                boolean notPick = prev[j];
                boolean pick = false;
                if(nums[i] <= j) {
                    pick = prev[j - nums[i]];
                }

                curr[j] = pick || notPick;
            }
            prev = curr;
        }

        return prev[halfSum];
    }
}