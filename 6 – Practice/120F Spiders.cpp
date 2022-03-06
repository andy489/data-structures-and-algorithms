// https://codeforces.com/problemset/problem/120/F

#include <iostream>
#include <vector>
#include <list>

using namespace std;

typedef pair<int, int> pii;
#define x first
#define y second

vector<list<int>> adj;
vector<bool> vis;

pair<int, int> dfs(int u = 1) {
    vis[u] = true;

    pii r(0, u);

    for (int child:adj[u]) {
        if (!vis[child]) {
            pii p = dfs(child);
            r = max(r, make_pair(p.x + 1, p.y));
        }
    }
    return r;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int spiders;
    cin >> spiders;

    int length_construction = 0;

    int n;
    while (spiders--) {
        cin >> n;
        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, false);

        int u, v;
        for (int i = 1; i < n; ++i) {
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        pii node1 = dfs();
        vis.assign(n + 1, false);
        pii node2 = dfs(node1.y);

        length_construction += node2.x;
    }

    cout << length_construction;

    return 0;
}
