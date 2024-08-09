class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int i =0;
        int n =nums.length;

        for(int j = i+2;j<n;j++)
        {
            if(nums[i] != nums[j]){
                nums[i+2] = nums[j];
                i++;
            } 
        }

        return i+2 ;
    }
}
