#include<bits/stdc++.h>
using namespace std;
bool palindrome(int x){
    int n = x;
    long int rev =0;
        while(x != 0){
            long int last = x % 10;
            
            rev =(long)(rev*10)+last;
            // 2147483647  to  –2147483648 
            if(rev > INT_MAX)
                return 0;
            if(rev < INT_MIN)
                return 0;
            x=(int) x/10;
        }
       if (n < 0) return false;
        else if (rev == n) return true;
        else return false;
    }

 int main()
 {
    int x;
    cin>>x;
    
    cout<<palindrome(x);
    return 0;
 }
        
  
