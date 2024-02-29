#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums[low], nums[mid]);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums[mid], nums[high]);
                high--;
            }
        }
    }
};

int main() {
    Solution solution;
    vector<int> colors = {2, 0, 1, 2, 1, 0};
    
    cout << "Before sorting:" << endl;
    for (int color : colors) {
        cout << color << " ";
    }
    cout << endl;

    solution.sortColors(colors);

    cout << "After sorting:" << endl;
    for (int color : colors) {
        cout << color << " ";
    }
    cout << endl;

    return 0;
}
