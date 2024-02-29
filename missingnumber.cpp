
#include <bits/stdc++.h>
using namespace std;

int missingNumber(vector<int>&nums) {
    int n = nums.size();
    //Summation of first N numbers:
    int sum = (n * (n + 1)) / 2;

    //Summation of all array elements:
    int s2 = 0;
    for (int i = 0; i < n - 1; i++) {
        s2 += nums[i];
    }

    int missingNum = sum - s2;
    return missingNum;
}

int main()
{
    vector<int> nums;
    int ans = missingNumber(nums);
    cout << "The missing number is: " << ans << endl;
    return 0;
}