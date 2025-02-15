class Solution {
    public int punishmentNumber(int n) {
        int totalSum = 0;

        for(int i = 1; i <= n; i++){
            int sqr = i * i;

            if(isValid(sqr,i,0)){
                totalSum += sqr;
            } 
        }

        return totalSum;
    }

    public boolean isValid(int num,int target,int sum){
        if(num == 0) return sum == target;

        int temp = num;
        int part = 0;
        int factor = 1;

        while(temp > 0){
            int remainder = temp % 10;
            part = remainder * factor + part;
            temp /= 10;
            if(isValid(temp,target,sum+part)) return true;

            factor *= 10; 
        }
        
        return false;
    }
}