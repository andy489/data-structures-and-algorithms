#include<algorithm>
#include<iostream>
#include<vector>

int main() {
    using namespace std;

    // NOTE: These are sorted
    vector<int> nums { 41, 45, 61, 231, 764 };

    int searchNum = 62;
    auto it = lower_bound(nums.begin(), nums.end(), searchNum);

    if (it != nums.end()) {
        if (searchNum == *it) {
            cout << "found " << *it << " at " << it - nums.begin() << endl;
        } else {
            cout << searchNum << " can be inserted at " << it - nums.begin()
                << " and the numbers will remain sorted"<< endl;
        }
    } else {
        cout << "not in range" << endl;
    }

    cout << endl;

    vector<int> copiedNums;
    copy(nums.begin(), nums.end(), copiedNums.begin());

    for (int num : copiedNums) {
        cout << num << " ";
    }

    return 0;
}
