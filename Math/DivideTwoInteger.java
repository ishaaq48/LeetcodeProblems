class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int rem = 0;
        int temp = 0;
        rem = dividend % divisor;
        if(rem == 0) return dividend / divisor;
        else temp = (dividend - rem) / divisor;
        return temp;
    }
}