class Solution {
    public int numOfSubarrays(int[] arr) {
        int cur_sum = 0;
        int even_cnt = 0;
        int odd_cnt = 0;
        int MOD = (int) Math.pow(10,9) + 7;
        int res = 0;

        for(int n : arr){
            cur_sum += n;

            if(cur_sum % 2 == 1) {
                res = (res + even_cnt + 1) % MOD;
                odd_cnt++;
            }
            else {
                res = (res + odd_cnt) % MOD;
                even_cnt++;
            }
        } 

        return res;
    }
}