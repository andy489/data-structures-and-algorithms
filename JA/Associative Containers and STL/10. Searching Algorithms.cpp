#include<algorithm>
#include<iostream>
#include<vector>

int main() {
    using namespace std;

    vector<int> nums { 61, 41, 231, 764, 45 };
    auto it = find(nums.begin(), nums.end(), 231);

    if (it != nums.end()) {
        cout << "found " << *it << " at " << it - nums.begin() << endl;
    } else {
        cout << "not found" << endl;
    }

    cout << "minimum:" << endl;
    cout << *min_element(nums.begin(), nums.end()) << endl;
    cout << *min_element(nums.begin(), nums.begin()) << endl;

    cout << "maximum:" << endl;
    cout << *max_element(nums.begin(), nums.end()) << endl;

    return 0;
}
