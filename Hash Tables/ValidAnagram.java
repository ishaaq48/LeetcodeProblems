class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        int[] countS = new int[26];
        int[] countT = new int[26];

        for(int i =0; i < n; i++)
        {
            countS[s.charAt(i)-'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++)
        {
            if(countS[i] != countT[i]) return false;
        }
        return true;
    }
}
