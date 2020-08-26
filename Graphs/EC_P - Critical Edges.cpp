// github.com/andy489

// https://www.spoj.com/problems/EC_P/

// Additional: https://codeforces.com/blog/entry/68138

#include <iostream>
#include <vector>
#include <list>
#include <set>

using namespace std;

vector<list<int>> adj;
vector<bool> vis;

vector<int> tin, low; //tin = time of entry into node
// low -> none of the vertices child and its descendants in the DFS traversal tree
// has a back-edge to vertex v or any of its ancestors (v, child)
int timer;

set<pair<int, int>> ans;

void dfs(int v, int p = -1) {
    vis[v] = true;
    tin[v] = low[v] = timer++;
    for (const int& child : adj[v]) {
        if (child == p) continue;
        if (vis[child]) {
            low[v] = min(low[v], tin[child]);
        } else {
            dfs(child, v);
            low[v] = min(low[v], low[child]);
            if (low[child] > tin[v])
                if (child > v)
                    ans.insert({v, child});
                else
                    ans.insert({child, v});
        }
    }
}

int main() {
    int t, n, m, u, v;
    cin >> t;
    for (int i = 1; i <= t; ++i) {
        cin >> n >> m;
        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, 0);
        tin.assign(n + 1, 0);
        low.assign(n + 1, 0);

        while (m--) {
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        dfs(1);
        cout << "Caso #" << i << '\n';
        if (ans.size()) {
            cout << ans.size() << '\n';
            for (const auto &edge:ans) {
                cout << edge.first << ' ' << edge.second << '\n';
            }
        } else
            cout << "Sin bloqueos\n";
        ans.clear();
    }
}

/*
3

5 4
1 2
4 2
2 3
4 5

5 5
1 2
1 3
3 2
3 4
5 4

4 6
1 3
1 4
2 1
3 2
4 2
4 3
*/
