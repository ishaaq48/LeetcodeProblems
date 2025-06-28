class Solution {
    public int f(int i,int j,int[] cuts,int left,int right,int[][] dp){
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int cost = Integer.MAX_VALUE;
        for(int c = left; c <= right; c++) {
            int lcost = f(i,cuts[c],cuts,left, c-1,dp);
            int rcost = f(cuts[c],j,cuts,c+1, right,dp);
            cost = Math.min(cost, lcost+rcost + (j - i)); 
        }

        return dp[left][right] = cost;
    }
    public int minCost(int n, int[] cuts) {
        int cut_length = cuts.length;
        int[][] dp = new int[cut_length][cut_length];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        Arrays.sort(cuts);
        return f(0, n, cuts,0, cut_length-1,dp);
    }
}