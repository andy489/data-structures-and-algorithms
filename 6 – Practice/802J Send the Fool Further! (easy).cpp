// https://codeforces.com/problemset/problem/802/J

#include <iostream>
#include <vector>
#include <list>

using namespace std;

typedef pair<int, int> pii;

vector<list<pii>> adj;
vector<bool> vis;

int dfs(int u = 0) {
    vis[u] = 1;
    int m = 0;

    for (const auto &child: adj[u]) {
        if (!vis[child.first]) {
            m = max(m, dfs(child.first) + child.second);
        }
    }

    return m;
}

int main() {
    int n;
    cin >> n;

    adj.resize(n);
    vis.resize(n);

    int u, v, w;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v >> w;

        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }

    cout << dfs();

    return 0;
}
