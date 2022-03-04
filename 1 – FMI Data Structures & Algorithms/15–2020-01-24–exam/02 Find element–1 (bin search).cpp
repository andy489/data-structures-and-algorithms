// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/find-element-sda

#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> arr; // sorted

void bin_search(int e) {
    int l = 0;
    int r = n - 1;
    int m;
    int ans = -1;

    while (l <= r) {
        m = l + (r - l) / 2;

        if (arr[m] > e) {
            r = m - 1;
        } else if (arr[m] < e) {
            l = m + 1;
        } else {
            ans = m;
            break;
        }
    }

    if (ans == -1) {
        cout << l << endl;
    } else { // naive
        int lp = m; // left position
        int rp = m; // right position

        while (rp < n && arr[rp] == arr[m]) {
            ++rp;
        }

        while (lp >= 0 && arr[lp] == arr[m]) {
            --lp;
        }
        
        cout << lp + 1 << ' ' << rp - 1 << endl;
    }
}

int main() {
    cin >> n;
    arr.resize(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    int q;
    cin >> q;

    int e;
    while (q--) {
        cin >> e;
        bin_search(e);
    }

    return 0;
}
