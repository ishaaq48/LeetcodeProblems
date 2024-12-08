class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        
        int sign = 1;
        int start = 0;
        if(s.charAt(0) == '-'){
            sign = -1;
            start++;
        }else if (s.charAt(0) == '+') {
            start++;
        }
        long ans = 0;
        for(int i = start; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9') break;
            ans = ans * 10 + (ch - '0');
            if(sign == 1 && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (ans * sign);
    }
}