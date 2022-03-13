// https://cses.fi/problemset/task/1691

#include <iostream>
#include <vector>
#include <set>

using namespace std;

#define fast_ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

vector<multiset<int>> adj;
vector<int> deg;
vector<int> euler_cycle;

void dfs(int u = 1) {
    while (!adj[u].empty()) {
        int v = *adj[u].begin();

        adj[u].erase(adj[u].begin());
        adj[v].erase(u);
        dfs(v);
    }

    euler_cycle.push_back(u);
    return;
}

int main() {
    fast_ios;

    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);
    deg.resize(n + 1);

    euler_cycle.reserve(m + 1);

    int u, v;
    for (int i = 0; i < m; ++i) {
        cin >> u >> v;

        adj[u].insert(v);
        adj[v].insert(u);

        ++deg[u], ++deg[v];
    }

    for (int i = 1; i <= n; ++i) {
        if (deg[i] & 1) {
            cout << "IMPOSSIBLE";
            return 0;
        }
    }

    dfs();

    if (euler_cycle.size() != m + 1) {
        cout << "IMPOSSIBLE";
        return 0;
    }

    for (int v: euler_cycle) {
        cout << v << " ";
    }

    return 0;
}
