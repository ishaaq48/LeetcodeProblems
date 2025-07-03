class Solution {
    public int minSwaps(int[] nums) {
        List<Integer> evenI = new ArrayList<>();
        List<Integer> oddI = new ArrayList<>(); 

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0)
                evenI.add(i);
            else oddI.add(i);
        }
        int n = evenI.size();
        int m = oddI.size();

        if(Math.abs(n - m) > 1) return -1;

        int res = Integer.MAX_VALUE;
        if(n >= m){
            int swap = 0;
            for(int i = 0 ; i < n; i++){ 
                // curr - i, target - 2 * i
                // target index - curr index -> no of swap cnt;
                swap += Math.abs(evenI.get(i) - 2 * i); 
            }
            res = Math.min(res, swap);
        }
        if(m >= n){
            int swap = 0;
            for(int i = 0 ; i < m; i++){
                swap += Math.abs(oddI.get(i) - 2 * i);
            }
            res = Math.min(res, swap);
        }

        return res;
    }
}