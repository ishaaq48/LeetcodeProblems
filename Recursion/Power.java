class Solution {
    public double myPow(double x, int n) {
       
       if(n == 0) return 1;
       if(n == 1) return x;

       if(n < 0)
       {
        x = 1 / x;
          if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE; 
                return x * myPow(x, n);
            } else {
                n = -n;
            }
       }

       double half = myPow(x,n/2);

       if(n % 2 == 0) return half * half;
       else return x * half * half;
       
    }
}
// class Solution {
//     public double myPow(double x, int n) {
//         double ans = 1.0;
//         long m = n;
//         if(m < 0) m = -1 * m;
//         while(m > 0)
//         {
//             if(m % 2 == 1)
//             {
//                 ans = ans * x;
//                 m = m-1;
                
//             }
//             else
//             {
//                 x = x * x;
//                 m = m/2;
//             }
//         }
//         if(n < 0) ans = (double)(1.0) / (double)(ans);
//         return ans; 

//     }
// }