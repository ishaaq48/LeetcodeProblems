class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max_so_far = nums[0],min_so_far = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = max_so_far;
            max_so_far = Math.max(nums[i], Math.max(max_so_far * nums[i],min_so_far * nums[i]));
            min_so_far = Math.min(nums[i], Math.min(min_so_far * nums[i], temp * nums[i]));
            ans = Math.max(ans,max_so_far); 
        }

        return ans;
    }
}