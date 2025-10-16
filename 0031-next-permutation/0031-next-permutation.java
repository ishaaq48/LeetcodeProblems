class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            Arrays.sort(nums);
        } else {
            for(int i = n-1; i >= 0; i--){
                if(nums[i] > nums[ind]){
                    swap(nums,i,ind);
                    break;
                }
            }

            int l = ind+1, r = n-1;
            while(l < r){
                swap(nums, l, r);
                l++;
                r--;
            }
        }
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}