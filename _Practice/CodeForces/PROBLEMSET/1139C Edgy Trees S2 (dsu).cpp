// github.com/andy489

// https://codeforces.com/problemset/problem/1139/C

#include <iostream>

using namespace std;

const int MOD = 1e9 + 7;

long long ds[100001], nodes[100001], dp[100001][2];

int find(int u) {
    return ds[u] == u ? u : ds[u] = find(ds[u]);
}

void merge(int u, int v) {
    int x = find(u), y = find(v);
    if (x != y)
        ds[x] = y;
}

int main() {
    int n, k, i(1), j, u, v, c;
    cin >> n >> k;

    for (; i <= n; ++i)
        ds[i] = i;

    for (i = 1; i < n; ++i) {
        cin >> u >> v >> c;
        if (!c)
            merge(u, v);
    }

    for (i = 1; i <= n; ++i) {
        ++nodes[find(i)];
        dp[i][0] = 1;
    }

    for (i = 2; i <= k; ++i) {
        for (j = 1; j <= n; ++j) {
            dp[j][1] = (dp[j][0] * ((n - nodes[find(j)] + MOD) % MOD) % MOD + dp[j][1] * n % MOD) % MOD;
            dp[j][0] = (dp[j][0] * nodes[find(j)]) % MOD;
        }
    }

    long long ans(0);

    for (i = 1; i <= n; ++i)
        ans = (ans + dp[i][1]) % MOD;
    return cout << ans, 0;
}
