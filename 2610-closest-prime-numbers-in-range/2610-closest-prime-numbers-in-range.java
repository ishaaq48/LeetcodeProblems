class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right+1];

        for(int i = 2; i <= right; i++){
            prime[i] = true;
        }        

        prime[0] = false;
        prime[1] = false;

        for(int p = 2; p * p <= right; p++){

            if(prime[p] == true){
                for(int i = p * p; i <= right; i += p){
                    prime[i] = false;
                }
            }
        }

        int[] ans = new int[2];
        int num1 = -1, num2 = -1;
        int prev_prime = -1, min_diff = Integer.MAX_VALUE;
        
        for(int i = left; i <= right; i++){
           if(prime[i]){
            if(prev_prime != -1){
                int diff = i - prev_prime;
                if(diff < min_diff){
                    min_diff = diff;
                    num1 = prev_prime;
                    num2 = i;
                }
            }

            prev_prime = i;
           }
        }        

        return (num1 == -1) ? new int[]{-1,-1} : new int[]{num1,num2};
    }
}