// https://www.hackerrank.com/contests/practice-3-sda/challenges/cows-sda

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool validate(int mid, const vector<int> &huts, int k) {
    int n = huts.size();
    int position = huts[0];

    int cows = 1;

    for (int i = 1; i < n; ++i) {
        if (huts[i] - position >= mid) {
            position = huts[i];
            ++cows;
            
            if (cows == k) {
                return true;
            }
        }
    }
    return false;
}

int bin_search_on_ans(const vector<int> &huts, int k) {
    int n = huts.size();

    int l = huts[0];
    int r = huts[n - 1];
    int mid;

    int ans = -1;

    while (l < r) {
        mid = l + (r - l) / 2;

        if (validate(mid, huts, k)) {
            ans = max(ans, mid);
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return ans;
}

int main() {
    int n, k;
    cin >> n >> k;

    vector<int> huts(n);

    for (int i = 0; i < n; ++i) {
        cin >> huts[i];
    }

    sort(huts.begin(), huts.end());

    cout << bin_search_on_ans(huts, k);

    return 0;
}
