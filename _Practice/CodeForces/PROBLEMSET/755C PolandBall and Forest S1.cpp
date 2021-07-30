// github.com/andy489

// https://codeforces.com/problemset/problem/755/C

#include <iostream>
#include <vector>
#include <list>

#define pb(x) push_back(x)

using namespace std;

vector<list<int>> adj;
vector<bool> vis;

void dfs(int v) {
    vis[v] = true;
    for (auto x: adj[v])
        if (!vis[x])
            dfs(x);
}

int main() {
    int n, i = 1, u, trees = 0;
    cin >> n;
    adj.assign(n + 1, list<int>());
    vis.assign(n + 1, false);
    for (; i <= n; ++i)
        cin >> u, adj[i].pb(u), adj[u].pb(i);
    for (i = 1; i <= n; ++i)
        if (!vis[i])
            dfs(i), ++trees;
    return cout << trees, 0;
}
