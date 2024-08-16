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
class Solution {
    private int getSquareSum(int n)
    {
        int currSum = 0;
        while(n != 0)
        {
            int remainder = (n % 10);
            currSum += remainder * remainder;
            n /= 10;
        }
        return currSum;

    }
//optimal solution 
//     public boolean isHappy(int n) {
//         int slow = getSquareSum(n);
//         int fast = getSquareSum(getSquareSum(n));

//      //Fast and slow pointer approach
//         while((slow != fast) && (fast != 1))
//         {
//             slow = getSquareSum(slow);
//             fast = getSquareSum(getSquareSum(fast));
//         }

//         return fast == 1;
//     }
// }
