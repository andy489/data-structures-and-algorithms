// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2351

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<int> vis;

void dfs(int u) {
    vis[u] = true;

    for (const auto &child:adj[u]) {
        if (!vis[child]) {
            dfs(child);
        }
    }
}

int main() {
    int q;
    cin >> q;

    while (q--) {
        int n, m;
        cin >> n >> m;

        adj.assign(n, list<int>());
        vis.assign(n, false);

        int u, v;
        while (m--) {
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        int comp = 0;

        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                dfs(i);
                ++comp;
            }
        }

        if (comp) {
            cout << comp << ' ';
        }
    }

    return 0;
}
