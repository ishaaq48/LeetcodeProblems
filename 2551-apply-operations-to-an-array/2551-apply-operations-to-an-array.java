class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            
        }

        int insert_pos = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0)
                nums[insert_pos++] = nums[i];
        }

        while(insert_pos < n)
            nums[insert_pos++] = 0;
        

        return nums;

    }
}