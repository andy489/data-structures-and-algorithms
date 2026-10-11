// https://codeforces.com/contest/872/problem/B

#include <iostream>
#include <vector>

using namespace std;

vector<int> log2;
vector<vector<int>> st;

int min(int a, int b) {
    return a > b ? b : a;
}

int max(int a, int b) {
    return a > b ? a : b;
}

void build_sparse_table(int n) {
    int k = log2[n];

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            st[j][i] = min(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
        }
    }
}

int rmq(int L, int R) {
    int j = log2[R - L + 1];
    return min(st[j][L], st[j][R - (1 << j) + 1]);
}

void preprocess_log2(int n) {
    log2.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

int main() {
    int n, k;
    cin >> n >> k;

    preprocess_log2(n);

    int mx = -1e9;
    int mn = 1e9;

    st.resize(log2[n] + 1, vector<int>(n + 1));

    for (int i = 0; i < n; ++i) {
        cin >> st[0][i];
        mx = max(mx, st[0][i]);
        mn = min(mn, st[0][i]);
    }

    if (k == 1) {
        cout << mn;
    } else if (k > 2) {
        cout << mx;
    } else {
        build_sparse_table(n);

        int maxi = -1e9;

        for (int i = 0; i < n - 1; ++i) {
            int l = rmq(0, i);
            int r = rmq(i + 1, n - 1);

            maxi = max(maxi, max(l, r));
        }

        cout << maxi;
    }

    return 0;
}
