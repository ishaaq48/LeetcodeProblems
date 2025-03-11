class Solution {
    public int numberOfSubstrings(String s) {
        return atleast(s);
    }

    public int atleast(String s) {
        HashMap<Character, Integer> char_count = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            char_count.put(ch, char_count.getOrDefault(ch, 0) + 1);

            while (char_count.size() == 3) {
                res += (s.length() - r);

                char left_char = s.charAt(l);

                char_count.put(left_char, char_count.get(left_char) - 1);
                if (char_count.get(left_char) == 0) {
                    char_count.remove(left_char);
                }

                l++;
            }
        }

        return res;
    }
}