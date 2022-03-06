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

    for (int child: adj[v]) {
        if (!vis[child]) {
            dfs(child);
        }
    }
}

int main() {
    int n;
    cin >> n;

    adj.resize(n + 1);
    vis.resize(n + 1);

    int u;
    for (int i = 1; i <= n; ++i) {
        cin >> u;

        adj[i].pb(u);
        adj[u].pb(i);
    }

    int trees = 0;
    for (int i = 1; i <= n; ++i) {
        if (!vis[i]) {
            dfs(i);

            ++trees;
        }
    }

    cout << trees;

    return 0;
}
