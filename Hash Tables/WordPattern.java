class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character,String> cs = new HashMap<>();
        Map<String,Character> sc = new HashMap<>();
        int n = pattern.length();
        int m = words.length;
        if( m != n) return false;

        for(int i = 0; i < n; i++)
        {
            char c = pattern.charAt(i);
            String word = words[i];
            // Character to String mapping
            if(cs.containsKey(c))
            {
                if(!cs.get(c).equals(word)) return false;
            }
            else{
                cs.put(c,word);
            }
            // String to character mapping
            if(sc.containsKey(word))
            {
                
                if(!sc.get(word).equals(c)) return false;
            }
            else{
                sc.put(word,c);
            }
        }
        return true;
    }
}
