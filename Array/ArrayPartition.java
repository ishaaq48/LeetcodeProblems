class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i =0;
        int mini = 0;
        while(i < nums.length)
        {
            mini += nums[i];
            i += 2;
        }
        return mini;
    }
}
