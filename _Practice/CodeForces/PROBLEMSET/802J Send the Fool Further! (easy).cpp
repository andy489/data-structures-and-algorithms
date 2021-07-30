// github.com/andy489

// https://codeforces.com/problemset/problem/802/J

#include <iostream>
#include <vector>
#include <list>

using namespace std;

typedef pair<int, int> pii;

vector<list<pii>> adj;
vector<bool> vis;

int dfs(int u) {
    vis[u] = 1;
    int m = 0;
    for (const auto &child: adj[u])
        if (!vis[child.first])
            m = max(m, dfs(child.first) + child.second);
    return m;
}

int main() {
    int n, i(1), u, v, w;
    cin >> n;

    adj.assign(n, list<pii>());
    vis.assign(n, 0);

    for (; i < n; ++i) {
        cin >> u >> v >> w;
        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }

    return dfs(0), 0;
}
