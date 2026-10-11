// https://codeforces.com/problemset/problem/1139/C

#include <iostream>
#include <vector>

using namespace std;

const int MOD = 1e9 + 7;

long long nodes[100001], dp[100001][2];

int n;

vector<long long> par;

int find_set(int u) {
    return par[u] == u ? u : par[u] = find_set(par[u]);
}

void unite_sets(int u, int v) {
    int x = find_set(u);
    int y = find_set(v);

    if (x != y) {
        par[x] = y;
    }
}

void init_sets() {
    par.resize(n + 1);

    for (int i = 1; i <= n; ++i) {
        par[i] = i;
    }
}

int main() {
    int k;
    cin >> n >> k;

    init_sets();

    int u, v, c;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v >> c;

        if (!c) {
            unite_sets(u, v);
        }
    }

    for (int i = 1; i <= n; ++i) {
        ++nodes[find_set(i)];

        dp[i][0] = 1;
    }

    for (int i = 2; i <= k; ++i) {
        for (int j = 1; j <= n; ++j) {
            dp[j][1] = (dp[j][0] * ((n - nodes[find_set(j)] + MOD) % MOD) % MOD + dp[j][1] * n % MOD) % MOD;
            dp[j][0] = (dp[j][0] * nodes[find_set(j)]) % MOD;
        }
    }

    long long ans = 0;

    for (int i = 1; i <= n; ++i) {
        ans = (ans + dp[i][1]) % MOD;
    }

    cout << ans;

    return 0;
}
