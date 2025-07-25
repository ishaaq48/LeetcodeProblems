class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return find(0, nums, target, nums.length, dp);
    }

    public int find(int i, int[] nums, int target, int n, Map<String, Integer> dp){
        String key = i + "," + target;

        if(dp.containsKey(key))
            return dp.get(key);

        if(i == n){
            if(target == 0)
                return 1;
            else 
                return 0;
        }
        
        int pick = find(i+1, nums, target-nums[i], n, dp);
        int notPick = find(i+1, nums, target+nums[i], n, dp);

        dp.put(key, pick + notPick);
        return dp.get(key);
    }
}


// pick target - 1
// notpick target + 1