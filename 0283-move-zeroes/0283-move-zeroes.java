class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 1;

        while(r < nums.length) {
            if(nums[l] == 0 && nums[r] != 0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r++;
            }
            else if(nums[l] != 0){
                l++;
                if(r <= l) r = l + 1;
            }
            else{
                r++;
            }
        }
    }
}