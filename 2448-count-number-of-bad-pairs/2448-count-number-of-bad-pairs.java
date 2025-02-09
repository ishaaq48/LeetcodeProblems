class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPair = (n * (n - 1)) / 2;
        long goodPair = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int key = nums[i] - i;
            goodPair += map.getOrDefault(key,0);
            map.put(key, map.getOrDefault(key,0) + 1);
        }

        return totalPair - goodPair;
    }
}