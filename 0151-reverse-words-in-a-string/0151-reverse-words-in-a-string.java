class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        String s2 = "";
        for(int i = str.length-1; i >= 0; i--){
            if(i != 0){
                s2 += str[i] + " ";
            }else if(i == 0){
                s2 += str[i];
            }   
        }
        return s2;
    }
}