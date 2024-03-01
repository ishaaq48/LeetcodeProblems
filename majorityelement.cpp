#include<bits/stdc++.h>
using namespace std;

/*int majorityElement(vector<int> arr,int n) {
	for(int i = 0; i < n; i++){
		int cont = 0;
		for (int j = 0; j < n; ++j)
		{
			if(arr[j] == arr[i]){
				cont++;
			}
		}
		if(cont > n/2){
			return arr[i];
		}
	}
}*/
int majorityElement(vector<int> nums,int n){
	 	//n log n + O(N) -tc
		//O(n) - sc
       map<int,int> mpp;
        for(int i = 0; i < n; i++){
                mpp[nums[i]]++;
        }
        for(auto it:mpp){
            if(it.second > n/2) return it.first;
        }
        return -1;
}
int majorityElementsss(vector<int> nums){
	 int n =nums.size();
       int cnt = 0;
       int el;
        for(int i = 0; i < n; i++){
                if(cnt == 0){
                cnt = 1;
                el = nums[i];
                }
                else if(nums[i] == el){
                    cnt++;
                }
                else
                    cnt--;
        }
          int cnt1 = 0;
    for (int i = 0; i < n; i++) {
        if (nums[i] == el) cnt1++;
    }

    if (cnt1 > (n / 2)) return el;
    return -1;
}
int main(){
	vector<int> nums = {2, 2, 1, 1, 1, 2, 2};
    int ans = majorityElementsss(nums);
    cout << "The majority element is: " << ans << endl;
    return 0;
}