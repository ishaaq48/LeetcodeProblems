class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        int ind = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; i += 3) {
            if(nums[i+2] - nums[i] > k)
                return new int[][] {};

            ans[ind][0] = nums[i];
            ans[ind][1] = nums[i+1];
            ans[ind][2] = nums[i+2];
            ind++;
        }

        return ans;
    }
}