class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] dp_max = new int[n]; // maximum positive Integer subarray
        int[] dp_min = new int[n]; // minimum negative Integer subarray 
        dp_max[0] = nums[0];
        max = dp_max[0];
        dp_min[0] = nums[0];
        min = dp_min[0];

        for(int i = 1; i < n; i++){
            dp_max[i] = Math.max(nums[i], nums[i] + dp_max[i-1]);
            dp_min[i] = Math.min(nums[i], nums[i] + dp_min[i-1]);

            max = Math.max(max, dp_max[i]);
            min = Math.min(min, dp_min[i]);
        } 

        // max  -  min 
        // posi - abs(negative)
        return Math.max(max,Math.abs(min));
    }
}