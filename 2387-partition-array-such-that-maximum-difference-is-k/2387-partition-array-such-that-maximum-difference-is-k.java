class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int mini = nums[0];
        
        for(int i = 0; i < nums.length; i++) {
            int maxi = nums[i];
            if(maxi - mini > k) {
                mini = nums[i];
                maxi = nums[i];
                cnt++;
            }
        }

        return cnt+1;
    }
}