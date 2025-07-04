class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int numsSize = nums.length;
        convertToBinaryNums(nums, numsSize);
        return countAtMost(nums, k, numsSize) - countAtMost(nums, k-1, numsSize);
    }
    public int countAtMost(int[] nums, int goal, int numsSize){
        if(goal < 0) return 0;
        int left = 0, sum = 0, count = 0;

        for(int right = 0; right < numsSize; right++)
        {
            sum += nums[right];

            while(sum > goal) 
            {
                sum -= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }
    public void convertToBinaryNums(int[] nums, int numsSize){
        for(int index = 0; index < numsSize; index++){
            if(nums[index] % 2 == 1) nums[index] = 1;
            else nums[index] = 0;
        }
    }
}