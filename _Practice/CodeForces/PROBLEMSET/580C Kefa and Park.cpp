// github.com/andy489

// https://codeforces.com/problemset/problem/580/C

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<int> vis, c;

int m, res;

void dfs(int u, int cnt) {
    vis[u] = 1;
    if (c[u])
        ++cnt;
    else
        cnt = 0;
    if (cnt > m)
        return;
    if (adj[u].size() == 1 && u != 1)
        ++res;
    for (const int &child:adj[u])
        if (!vis[child])
            dfs(child, cnt);
}

int main() {
    int n, i(1), u, v;
    cin >> n >> m;

    adj.assign(n + 1, list<int>());
    vis.assign(n + 1, 0);
    c.resize(n + 1);

    for (; i <= n; ++i)
        cin >> c[i];

    for (i = 1; i < n; ++i) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    return dfs(1, 0), cout << res, 0;
}
