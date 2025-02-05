class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int count = 0;
        char ca = '\0', cb = '\0', c2b = '\0', c2a = '\0';
        if (n != m)
            return false;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2)
                    return false;
                if (count == 1) {
                    ca = s1.charAt(i);
                    c2a = s2.charAt(i);
                }
                if (count == 2) {
                    cb = s1.charAt(i);
                    c2b = s2.charAt(i);
                }
            }
        }

        if (count == 0)
            return true;
        if (count == 2) {
            if (ca == c2b && cb == c2a)
                return true;
        }

        return false;
    }
}