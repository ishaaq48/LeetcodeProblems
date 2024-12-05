class Solution {
    public int smallestNumber(int n) {
        int length = Integer.toBinaryString(n).length();

        int result = (1 << length) - 1;

        if(result < n){
            result = (1 << (length + 1)) - 1;
        }
        return result;
    }
}