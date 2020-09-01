// github.com/andy489

// https://www.spoj.com/problems/RMQSQ/

#include <iostream>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

#define mxN 100000
#define K 17

struct SparseTable {
    int st[mxN][K + 1];

    SparseTable(int n, int *arr) {
        for (int i = 0; i < n; ++i)
            st[i][0] = arr[i];

        for (int j = 1; j <= K; ++j)
            for (int i = 0; i + (1 << j) <= n; ++i)
                st[i][j] = min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
    }
};

int main() {
    ios;

    int n, i(0);
    cin >> n;

    int arr[mxN];
    for (; i < n; ++i)
        cin >> arr[i];

    int log[mxN + 1];
    log[1] = 0;
    for (i = 2; i <= n; ++i)
        log[i] = log[i / 2] + 1;

    int q;
    cin >> q;

    SparseTable st(n, arr);

    int L, R;
    while (q--) {
        cin >> L >> R;
        int j = log[R - L + 1];
        cout << min(st.st[L][j], st.st[R - (1 << j) + 1][j]) << '\n';
    }
}
