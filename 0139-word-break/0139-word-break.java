class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        dp[n] = true;
        for(int i = n; i >= 0; i--){
            for(String w : wordDict){
                int w_len = w.length();
                if(i + w_len <= n && s.substring(i, i + w_len).equals(w))
                    dp[i] = dp[i+w_len];
                if(dp[i]) 
                    break;
            }
        }

        return dp[0];
    }
}