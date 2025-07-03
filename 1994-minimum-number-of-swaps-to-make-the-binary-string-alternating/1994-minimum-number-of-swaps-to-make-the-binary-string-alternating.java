class Solution {
    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();

        int one = 0;
        int zero = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == '1')
                one++;
            else zero++;
        }


        if(Math.abs(zero - one) > 1) return -1;

        int res = Integer.MAX_VALUE;

        if(zero >= one) {
            int swap = 0;
            for(int i = 0; i < n; i++) {
                char ex = (i % 2 == 0) ? '0' : '1';
                if(s.charAt(i) != ex) swap++;
            }
            res = Math.min(res, swap/2);
        }

        if(one >= zero) {
            int swap = 0;
            for(int i = 0; i < n; i++) {
                char ex = (i % 2 == 0) ? '1' : '0';
                if(s.charAt(i) != ex) swap++;
            }
            res = Math.min(res, swap/2);
        }
        
        return res;
    }
}