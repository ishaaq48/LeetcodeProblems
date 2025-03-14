class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int repeat = 0,maxLen = 0;
        Map<Character, Integer> freq = new HashMap<>();

        while(r < s.length()){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            repeat = Math.max(repeat, freq.get(s.charAt(r)));

            if(r - l + 1 - repeat > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }


        return maxLen;
    }
}