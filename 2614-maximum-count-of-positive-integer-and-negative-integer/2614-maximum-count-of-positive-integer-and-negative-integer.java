class Solution {
    public int maximumCount(int[] nums) {
        int lb = lowerBound(nums,0);
        int ub = upperBound(nums,0);

        return Math.max(lb, nums.length - ub);
    }

    public int lowerBound(int[] nums, int target){
        int low = 0,high = nums.length;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int upperBound(int[] nums, int target){
        int low = 0,high = nums.length;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] <= target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}