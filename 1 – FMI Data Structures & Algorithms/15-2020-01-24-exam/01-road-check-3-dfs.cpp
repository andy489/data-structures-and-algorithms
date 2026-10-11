// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2353

#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pii;

vector<vector<pair<int, int >>> adj;
vector<int> path;
vector<bool> vis;

void dfs(int &cost, int start = 0) {
    vis[start] = true;

    for (const auto &child : adj[path[start]]) {
        if (start + 1 < path.size() && child.first == path[start + 1]) {
            dfs(cost += child.second, start + 1);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    adj.assign(n, vector<pii>());

    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;
        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }

    int k;
    cin >> k;

    vis.resize(k);
    path.resize(k);

    for (int i = 0; i < k; ++i) {
        cin >> path[i];
    }

    int cost = 0;
    dfs(cost);

    for (int i = 0; i < k; ++i) {
        if (!vis[i]) {
            cost = -1;
            break;
        }
    }

    cout << cost;
    
    return 0;
}
