#include <iostream>
#include <vector>
#include <algorithm> // for sort
using namespace std;

int removeDuplicates(vector<int> &arr) {
    if (arr.empty()) return 0;
    int i = 0;
    for (int j = 1; j < arr.size(); j++) {
        if (arr[j] != arr[i]) {
            i++;
            arr[i] = arr[j];
        }
    }
    return i + 1;
}

int main() {
    vector<int> arr;
    int n;
    
    cout << "Enter the number of elements in the array: ";
    cin >> n;
    
    cout << "Enter " << n << " elements: ";
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        arr.push_back(num);
    }
    
    // Sort the vector (required for removing duplicates)
    sort(arr.begin(), arr.end());
    
    // Remove duplicates
    int k = removeDuplicates(arr);
    
    cout << "The array after removing duplicate elements is:" << endl;
    for (int i = 0; i < k; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}
