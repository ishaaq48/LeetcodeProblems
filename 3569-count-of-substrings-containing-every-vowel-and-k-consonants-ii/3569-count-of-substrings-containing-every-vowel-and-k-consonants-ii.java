class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleastK(word, k) - atleastK(word, k+1);
    }
    public long atleastK(String word, int k){
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int nonVowel =0;
        int l = 0;
        long res = 0;

        for(int r = 0; r < word.length(); r++){
            char ch = word.charAt(r);

            if(isVowel(ch)) {
                vowelCount.put(ch, vowelCount.getOrDefault(ch,0) + 1);
            } else {
                nonVowel++;
            }

            while(vowelCount.size() == 5 && nonVowel >= k) {
                res += (word.length()-r);

                char leftChar = word.charAt(l);
                if(isVowel(leftChar)) {
                    vowelCount.put(leftChar, vowelCount.get(leftChar) - 1);
                    if(vowelCount.get(leftChar) == 0){
                        vowelCount.remove(leftChar);
                    }
                } else {
                    nonVowel--;
                }
                l++;
            }
        }

        return res;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}