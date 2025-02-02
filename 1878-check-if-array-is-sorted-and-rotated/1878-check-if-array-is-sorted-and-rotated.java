class Solution {
    public boolean check(int[] nums) {
        int point = 0;
        int j = 1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            // the key is % n - it make a circular array to check last element to first
            if(nums[i] > nums[(i + 1) % n]){
                point++;
            }
           if(point > 1){
            return false;
           }
        }

        return true;
    }
}