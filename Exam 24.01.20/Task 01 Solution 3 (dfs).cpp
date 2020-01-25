#include <bits/stdc++.h>
using namespace std;

void dfs(vector<vector<pair<int, int>>>& adj,
    vector<int>& path,
    vector<bool>& visited,
    int& cost, int start) {
    visited[start] = true;
    for (const auto& child : adj[path[start]])
    {
        if (start + 1 < path.size() && child.first == path[start + 1]) {
            dfs(adj, path, visited, cost += child.second, start + 1);
        }
    }
}

int main() {
    int N, M, K, a, b, w, cost(0);
    cin >> N >> M;
    vector<vector<pair<int, int>>> adj(N);
    while (M--) {
        cin >> a >> b >> w;
        adj[a].emplace_back(b, w);
        adj[b].emplace_back(a, w);
    }
    cin >> K;
    vector<int> path(K);
    vector<bool> visited(K);
    for (a = 0;a < K;++a) {
        cin >> path[a];
    }
    dfs(adj, path, visited, cost, 0);
    for (a = 0; a < K; ++a) {
        if (!visited[a]) {
            cout << "-1";
            return 0;
        }
    }
    cout << cost;
    return 0;
}
