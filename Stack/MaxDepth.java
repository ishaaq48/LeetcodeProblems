class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int ans=0,maxDepth = 0;
        for(int i =0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if( ch == '(')
            {
                st.push(ch);
                ans += 1;
                maxDepth = Math.max(ans,maxDepth);
                
            }
            else if(ch == ')')
            {
                st.pop();
                ans -= 1;
            }
        }
        return maxDepth;
    }
}
