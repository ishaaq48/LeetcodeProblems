class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> nextSmaller = nexSmaller(heights, heights.length);
        ArrayList<Integer> prevSmaller = preSmaller(heights, heights.length);
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            int width = nextSmaller.get(i) - prevSmaller.get(i) - 1;
            int area = width * heights[i];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    public ArrayList<Integer> nexSmaller(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, n));
      
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans.set(i, st.peek());
            }
            st.push(i);
        }
        return ans;
    }

    public ArrayList<Integer> preSmaller(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
      
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans.set(i, st.peek());
            }
            st.push(i);
        }

        return ans;
    }

}