class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < pattern.length() + 1; i++) {
            st.push(i + 1);
            while (!st.isEmpty() && (i == pattern.length() || pattern.charAt(i) == 'I')) {
                res.append(st.pop());
            }
        }

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.toString();
    }
}