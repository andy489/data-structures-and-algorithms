// github.com/andy489

// https://www.spoj.com/problems/THRBL/

#include <iostream>

using namespace std;

#define ios ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)
#define mxN 50000
#define K 16

int main() {
    ios;

    int n, i(0), j(1), q, A, B, ans(0);
    cin >> n >> q;

    int arr[mxN];
    for (; i < n; ++i)
        cin >> arr[i];

    int log[mxN + 1];
    log[1] = 0;
    for (i = 2; i <= n; ++i)
        log[i] = log[i / 2] + 1;

    int st[mxN][K + 1];
    for (i = 0; i < n; ++i)
        st[i][0] = arr[i];

    for (; j <= K; ++j)
        for (i = 0; i + (1 << j) <= n; ++i)
            st[i][j] = max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);

    while (q--) {
        cin >> A >> B;
        B -= 2;
        if (B - A == 0) {
            ++ans;
            continue;
        }
        j = log[B - A + 1];
        int maximum = max(st[A][j], st[B - (1 << j) + 1][j]);
        int L = arr[A - 1];
        if (L >= maximum)
            ++ans;
    }

    return cout << ans, 0;
}
