class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int el = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                count = 1;
                el = nums[i];
            } else if(el == nums[i]){
                count++;
            }else if(el != nums[i]){
                count--;
            }
        }  

        return el;  
    }
}