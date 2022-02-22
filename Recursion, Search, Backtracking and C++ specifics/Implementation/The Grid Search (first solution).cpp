// https://www.hackerrank.com/challenges/the-grid-search/problem
// 1st solution

#include <iostream>

using namespace std;

char G[1000][1000], P[1000][1000];

void solve() {
    int R, C, r, c;
    cin >> R >> C;

    for (int i = 0; i < R; ++i) {
        cin >> G[i];
    }

    cin >> r >> c;

    for (int i = 0; i < r; ++i) {
        cin >> P[i];
    }

    for (int i = 0; i <= R - r; ++i) {
        for (int j = 0; j <= C - c; ++j) {
            for (int a = 0; a < r; ++a) {
                for (int b = 0; b < c; ++b) {
                    if (G[i + a][j + b] != P[a][b])
                        goto L1;
                }
            }
            cout << "YES" << endl;
            return;

            L1:;
        }
    }
    cout << "NO" << endl;
}

int main() {
    int T;
    cin >> T;

    while (T--) {
        solve();
    }

    return 0;
}
