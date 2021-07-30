// github.com/andy489

// https://codeforces.com/problemset/problem/1139/C

#include <iostream>
#include <vector>
#include <list>

using namespace std;

typedef long long ll;

#define pb push_back

const int MOD = 1e9 + 7;

vector<list<int>> adj;
vector<int> vis;

void dfs(int u, ll &cnt) {
    vis[u] = true;
    ++cnt;
    for (const int &child: adj[u])
        if (!vis[child])
            dfs(child, cnt);
}

int main() {
    int n, k, i(1), u, v, c;
    ll all(1);
    cin >> n >> k;

    adj.assign(n + 1, list<int>());
    vis.assign(n + 1, 0);

    for (; i < n; ++i) {
        cin >> u >> v >> c;
        if (c) continue;
        adj[u].pb(v);
        adj[v].pb(u);
    }

    for (i = 1; i <= k; ++i) {
        all = (all * n) % MOD;
    }

    for (i = 1; i <= n; ++i) {
        ll cnt(0), j(0), curr(1);
        if (!vis[i])
            dfs(i, cnt);
        for (; j < k; ++j)
            curr = (curr * cnt) % MOD;
        all = (all - curr) % MOD;
    }
    return cout << (all + MOD) % MOD, 0;
}
