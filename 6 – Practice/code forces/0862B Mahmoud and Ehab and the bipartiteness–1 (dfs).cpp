// https://codeforces.com/problemset/problem/862/B

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<bool> vis;

void dfs(int &odd, int u = 1, int lvl = 0) {
    vis[u] = true;

    if (lvl & 1) {
        ++odd;
    }

    for (int child: adj[u]) {
        if (!vis[child]) {
            dfs(odd, child, lvl + 1);
        }
    }
}

int main() {
    int n;
    cin >> n;

    adj.resize(n + 1);
    vis.resize(n + 1);

    int u, v;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int odd = 0; //level

    dfs(odd);

    cout << (long long) (n - odd) * odd - n + 1;

    return 0;
}
