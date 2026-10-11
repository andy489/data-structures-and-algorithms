// https://codeforces.com/problemset/problem/1139/C

#include <iostream>
#include <vector>
#include <list>

using namespace std;

typedef long long ll;

const int MOD = 1e9 + 7;

vector<list<int>> adj;
vector<int> vis;

void dfs(int u, ll &cnt) {
    vis[u] = true;
    ++cnt;

    for (const int &child: adj[u]) {
        if (!vis[child]) {
            dfs(child, cnt);
        }
    }
}

int main() {
    int n, k;
    ll all = 1;
    cin >> n >> k;

    adj.resize(n + 1);
    vis.resize(n + 1);

    int u, v, c;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v >> c;

        if (c) {
            continue;
        }

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i <= k; ++i) {
        all = (all * n) % MOD;
    }

    for (int i = 1; i <= n; ++i) {
        ll cnt = 0;
        ll curr = 1;

        if (!vis[i]) {
            dfs(i, cnt);
        }

        for (int j = 0; j < k; ++j) {
            curr = (curr * cnt) % MOD;
        }

        all = (all - curr) % MOD;
    }

    cout << (all + MOD) % MOD;

    return 0;
}