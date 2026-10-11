// https://codeforces.com/problemset/problem/839/C

#include <iostream>
#include <vector>
#include <list>

using namespace std;

#define pb push_back

vector<list<int>> adj;

double dfs(int u = 1, int parent = -1) {
    double path = 0;

    for (int child:adj[u]) {
        if (child != parent) {
            path += dfs(child, u) + 1;
        }
    }

    return path ? path / (1.0 * adj[u].size() - (u != 1)) : 0;
}

int main() {
    int n;
    cin >> n;

    adj.assign(n + 1, list<int>());

    int u, v;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v;

        adj[u].pb(v);
        adj[v].pb(u);
    }

    cout << fixed << dfs();

    return 0;
}