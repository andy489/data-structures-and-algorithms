// https://www.hackerrank.com/contests/101hack34/challenges/beautiful-pairs

#include <iostream>
#include <vector>
#include <set>

using namespace std;

int beautifulPairs(const vector<int> &arr, multiset<int> &ms) {
    int pairs_cnt = 0;

    for (int e:arr) {
        auto it = ms.find(e);
        if (it != ms.end()) {
            ++pairs_cnt;
            ms.erase(it);
        }
    }

    if (ms.empty()) {
        return pairs_cnt - 1;
    } else {
        return pairs_cnt + 1;
    }
}

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);
    multiset<int> ms;

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    int e;
    for (int i = 0; i < n; ++i) {
        cin >> e;
        ms.insert(e);
    }

    cout << beautifulPairs(arr, ms);

    return 0;
}
