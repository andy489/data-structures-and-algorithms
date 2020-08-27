// github.com/andy489

// https://www.spoj.com/problems/SUBMERGE/

// Additional: https://cp-algorithms.com/graph/cutpoints.html

#include <iostream>
#include <vector>
#include <list>
#include <set>

using namespace std;

#define pb push_back

vector<list<int>> adj;
vector<bool> vis;
vector<int> tin, low, ans;

int timer;

set<int> art;

void dfs(int u, int par = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;
    int children = 0;
    for (const auto &child : adj[u]) {
        if (child == par)
            continue;
        if (vis[child]) {
            low[u] = min(low[u], tin[child]);
        } else {
            dfs(child, u);
            low[u] = min(low[u], low[child]);
            if (low[child] >= tin[u] && par != -1) {
                art.insert(u);
            }
            ++children;
        }
    }
    if (par == -1 && children > 1)
        art.insert(u);
}

int main() {
    int n, m, u, v;
    while (cin >> u >> v) {
        if (u == 0 && v == 0)
            break;

        n = u, m = v;

        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, false);
        tin.assign(n + 1, 0);
        low.assign(n + 1, 0);

        while (m--) {
            cin >> u >> v;
            adj[u].pb(v);
            adj[v].pb(u);
        }

        dfs(1);

        ans.pb(art.size());
        art.clear();
    }
    for (const auto &x:ans)
        cout << x << '\n';
    return 0;
}

/*
3 3
1 2
2 3
1 3
6 8
1 3
6 1
6 3
4 1
6 4
5 2
3 2
3 5
0 0
 ans:
 0
 1

6 7
1 6
1 2
1 5
5 2
1 3
3 4
4 1
0 0
 ans:
 1
*/
