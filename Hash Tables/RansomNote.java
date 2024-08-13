class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c : magazine.toCharArray())
        {
            if(!mp.containsKey(c))
            {
                mp.put(c,1);
            }
            else
            {
                int count = mp.get(c);
                mp.put(c,count+1);
            }
        }
        for(char c : ransomNote.toCharArray())
        {
            if(mp.containsKey(c))
            {
                int a = mp.get(c);
                if(a > 1) mp.put(c,a-1);
                else mp.remove(c);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
