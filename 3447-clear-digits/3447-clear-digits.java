class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if( c >= 'a' && c <= 'z'){
                st.push(c);
            }
            else{
                st.pop();
            }
        }
        if(st.isEmpty()) return ans.toString();

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();

        return ans.toString();
    }
}