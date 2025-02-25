class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefix = new HashMap<>();
        int sum = 0,cnt = 0;
        prefix.put(0,1);
        for(int i = 0; i < nums.length; i++){
            
            sum += nums[i];

            int remove = sum - k;

            cnt += prefix.getOrDefault(remove,0);    

            prefix.put(sum, prefix.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
}