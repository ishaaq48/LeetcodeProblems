class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int maxLen = 1;
        int maxI = 1;
        int maxD = 1;
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                inc++;
                maxI = Math.max(maxI,inc);
                dec = 1;
            }
            else if(nums[i] < nums[i+1]){
                dec++;
                maxD = Math.max(maxD,dec);
                inc = 1;
            }
            else{
                inc = 1;
                dec = 1;
            }
        }

        return Math.max(maxI,maxD);
    }
}