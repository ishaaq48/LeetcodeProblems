class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = triangle.get(n-1).get(i);
        }


        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[n];
            for(int j = 0; j < triangle.get(i).size(); j++){
                int down = triangle.get(i).get(j) + dp[j];
                int diagonal = triangle.get(i).get(j) + dp[j+1];
                
                curr[j] = Math.min(down, diagonal);
            }
            dp = curr;
        } 

        return dp[0];
    }
}