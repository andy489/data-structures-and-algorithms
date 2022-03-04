// https://www.hackerrank.com/contests/practice-3-sda/challenges/strawberries-sda

#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

int upper_bound(const vector<ll> &arr, ll l, ll r, ll target) {
    while (l < r) {
        ll mid = l + (r - l) / 2;

        if (target > arr[mid]) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    if (arr[l] >= target) {
        return l;
    } else {
        return -1;
    }
}

int main() {
    int n;
    cin >> n;

    vector<ll> strawberries(n);

    for (int i = 0; i < n; ++i) {
        cin >> strawberries[i];
    }

    int m;
    cin >> m;

    vector<ll> tasty(m);

    for (int i = 0; i < m; ++i) {
        cin >> tasty[i];
    }

    vector<ll> utility(n);
    utility[0] = strawberries[0];

    for (int i = 1; i < n; ++i) {
        utility[i] = strawberries[i] + utility[i - 1];
    }

    for (int i = 0; i < m; ++i) {
        int index = upper_bound(utility, 0, n - 1, tasty[i]);
        cout << index + 1 << endl;
    }

    return 0;
}
