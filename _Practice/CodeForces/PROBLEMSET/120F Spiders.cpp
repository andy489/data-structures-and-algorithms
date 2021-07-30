// github.com/andy489

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
    for (const auto &child:adj[u])
        if (!vis[child]) {
            pii p = dfs(child);
            r = max(r, make_pair(p.x + 1, p.y));
        }
    return r;
}
 
 
int main() {
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int spiders, n, i, u, v, len(0);
    cin >> spiders;
 
    while (spiders--) {
        cin >> n;
        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, false);
        for (i = 1; i < n; ++i) {
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
 
        pii node1 = dfs();
        vis.assign(n + 1, false);
        pii node2 = dfs(node1.y);
 
        len += node2.x;
    }
    return cout << len, 0;
}
