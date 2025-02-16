class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] ans = new int[size];
        boolean[] visited = new boolean[n+1];
        backtracking(0,ans,visited,size,n);
        return ans;
    }
    public boolean backtracking(int ind,int[] ans,boolean[] visited,int n,int startNum){
        if(ind == n) return true;

        if(ans[ind] != 0) return backtracking(ind+1,ans,visited,n,startNum);

        for(int i = startNum; i > 0; i--){
            if(visited[i]) continue;

            if(i == 1){
                ans[ind] = 1;
                visited[i] = true;
                if(backtracking(ind+1,ans,visited,n,startNum)) return true;

                ans[ind] = 0;
                visited[i] = false;
            } else if (ind + i < n && ans[ind + i] == 0) {
                ans[ind] = ans[ind + i] = i;
                visited[i] = true;
                
                if(backtracking(ind+1,ans,visited,n,startNum)) return true;

                ans[ind] = ans[ind + i] = 0;
                visited[i] = false;
            }
        }

        return false;
    }
}