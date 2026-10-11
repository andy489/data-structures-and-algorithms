// https://www.hackerrank.com/contests/practice-8-sda/challenges/christmas-decoration

#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <list>

using namespace std;

unordered_map<int, list<int>> adj;
unordered_set<int> vis;

void dfs(int u) {
    vis.insert(u);

    for (int child: adj[u]) {
        if (!vis.count(child)) {
            dfs(child);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    int u, v;
    while (m--) {
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int cnt = 0;
    for (const auto &kvp: adj) {
        if (!vis.count(kvp.first)) {
            ++cnt;
            dfs(kvp.first);
        }
    }

    int ans = n - (int) adj.size() + cnt;

    cout << ans;

    return 0;
}
