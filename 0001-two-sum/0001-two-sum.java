class Solution {
    public int[] twoSum(int[] nums, int target) {
        // {2 : 0, }
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(numToIndex.containsKey(key)){
                return new int[] {numToIndex.get(key), i};
            }

            numToIndex.put(nums[i], i);
        }        

        return new int[] {};
    }
}