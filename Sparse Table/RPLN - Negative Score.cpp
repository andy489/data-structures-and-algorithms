// github.com/andy489

// https://www.spoj.com/problems/RPLN/

#include <iostream>
#include <vector>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

#define mxN 100000
#define K 17

int n, log[mxN + 1], st[K][mxN];

void log2() {
    for (int i = 2; i <= mxN; ++i)
        log[i] = log[i >> 1] + 1;
}

void init() {
    for (int i = 0; i < n; ++i)
        cin >> st[0][i];

    int k = log[n];
    for (int j = 1; j <= k; ++j)
        for (int i = 0; i + (1 << j) <= n; ++i)
            st[j][i] = min(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
}

int query(int L, int R) {
    int j = log[R - L + 1];
    return min(st[j][L], st[j][R - (1 << j) + 1]);
}

int main() {
    ios;

    log2();

    int t;
    cin >> t;
    for (int k = 1; k <= t; ++k) {
        int q, L, R;
        cin >> n >> q;
        init();
        cout << "Scenario #" << k << ":\n";
        while (q--) {
            cin >> L >> R;
            --L, --R;
            cout << query(L, R) << '\n';
        }
    }
    return 0;
}
