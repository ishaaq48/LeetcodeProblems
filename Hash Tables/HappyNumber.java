class Solution {
    public boolean isHappy(int n) {
        Set<Integer> happy = new HashSet<>();
        while(n != 1)
        {
            if(happy.contains(n)) return false;
            happy.add(n);
            n = sumSquare(n);
        }
        return true;
    }
    public int sumSquare(int n){
        int rem = 0,square =0,sum = 0;
        while(n != 0)
        {
            rem = n % 10;
            square = rem * rem;
            sum += square; 
            n /= 10;
        }
        return sum;
    }
}
