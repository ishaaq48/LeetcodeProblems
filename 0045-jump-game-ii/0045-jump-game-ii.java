class Solution {
    public int jump(int[] nums){
        int n = nums.length;
        if(n == 1) return 0;
        int currReach = 0;
        int maxReach = 0;
        int jump = 0;

        for(int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if(maxReach >= n-1){
                return jump + 1;
            }

            if(i == currReach){
                if(maxReach > currReach) {
                    jump++;
                    currReach = maxReach;
                }
            }
        }

        return jump;
    }
    
}