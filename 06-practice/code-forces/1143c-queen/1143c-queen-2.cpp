// https://codeforces.com/problemset/problem/1143/C

#include <iostream>

using namespace std;

const int mxN = 1e5;

int p[mxN], c[mxN], s[mxN];

int main() {
    int n;
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        cin >> p[i] >> c[i], s[i] = c[i];
    }

    for (int i = 1; i <= n; i++) {
        if (p[i] > 0) {
            s[p[i]] &= c[i];
        }
    }

    bool flag = false;

    for (int i = 1; i <= n; ++i) {
        if (s[i]) {
            cout << i << ' ';

            flag = true;
        }
    }

    if (!flag) {
        cout << -1;
    }

    return EXIT_SUCCESS;
}
