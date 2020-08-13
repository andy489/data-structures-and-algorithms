// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2351

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<int> vis;

void dfs(int u) {
    vis[u] = true;
    for (const auto &child:adj[u])
        if (!vis[child])
            dfs(child);
}

int main() {
    int q, n, m, a, b;
    cin >> q;
    while (q--) {
        cin >> n >> m;
        adj.assign(n, list<int>());
        vis.assign(n, 0);

        while (m--) {
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        int comp(0);

        for (a = 0; a < n; ++a) {
            if (!vis[a]) {
                dfs(a);
                ++comp;
            }
        }

        if (comp)
            cout << comp << ' ';
    }
    return 0;
}
