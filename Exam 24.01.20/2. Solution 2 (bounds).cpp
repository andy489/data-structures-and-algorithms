// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/find-element-sda

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define all(x) x.begin(), x.end()

int main() {
    int n, q, e, i(0);
    cin >> n;

    vector<int> arr(n);

    for (; i < n; ++i)
        cin >> arr[i];

    cin >> q;

    while (q--) {
        cin >> e;

        auto l = lower_bound(all(arr), e),
                u = upper_bound(all(arr), e);

        if (l == arr.end() || *l != e)
            cout << l - arr.begin();
        else
            cout << (l - arr.begin()) << ' ' << u - arr.begin() - 1;
        cout << '\n';
    }
    return 0;
}
