// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

#include <iostream>

using namespace std;
const int mxN = 2e5 + 5;

int n, m;
int res[mxN], alice_scores[mxN], pos[mxN];

int bs_get_place(int x) {
    int l = 0;
    int r = n - 1;
    int mid;

    while (l < r) {
        mid = l + (r - l) / 2;

        if (res[mid] <= x) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }

    return res[r] <= x ? pos[r] : pos[r] + 1;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> res[i];
    }

    int curr_pos = 1;
    pos[0] = 1;

    for (int i = 1; i < n; ++i) {
        if (res[i] == res[i - 1]) {
            pos[i] = curr_pos;
        } else {
            pos[i] = ++curr_pos;
        }
    }

    cin >> m;

    for (int i = 0; i < m; ++i) {
        cin >> alice_scores[i];
        cout << bs_get_place(alice_scores[i]) << endl;
    }
}
