class Solution {
    public int myAtoi(String s) {
        // Step 1: Trim leading and trailing whitespace
        s = s.trim();
        if (s.isEmpty()) return 0;

        // Step 2: Handle sign if present
        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start++;
        } else if (s.charAt(0) == '+') {
            start++;
        }

        // Step 3: Convert digits to integer
        long ans = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break; // Stop if non-digit character is encountered

            ans = ans * 10 + (c - '0');
            // Step 4: Handle overflow and underflow
            if (sign == 1 && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (ans * sign);
    }
}
