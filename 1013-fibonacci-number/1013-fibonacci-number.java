class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibo(dp,n);
    }
    public int fibo(int[] dp, int n){
        if(n <= 1)
            return n;
        
        if(dp[n] != -1)
            return dp[n];

        return dp[n] = fibo(dp, n - 1) + fibo(dp, n - 2);
    }
}