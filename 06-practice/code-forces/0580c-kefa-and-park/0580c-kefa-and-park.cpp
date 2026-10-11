// https://codeforces.com/problemset/problem/580/C

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<int> vis, cats;

int m, res;

void dfs(int u = 1, int cnt = 0) {
    vis[u] = 1;

    cats[u] ? ++cnt : cnt = 0;

    if (cnt > m) {
        return;
    }

    if (adj[u].size() == 1 && u != 1) {
        ++res;
    }

    for (const int &child:adj[u]) {
        if (!vis[child]) {
            dfs(child, cnt);
        }
    }
}

int main() {
    int n;
    cin >> n >> m;

    adj.resize(n + 1);
    vis.resize(n + 1);
    cats.resize(n + 1);

    for (int i = 1; i <= n; ++i) {
        cin >> cats[i];
    }

    int u, v;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs();

    cout << res;

    return 0;
}
