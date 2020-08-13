// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2353

#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pii;

vector<vector<pair<int, int >>> adj;
vector<int> path;
vector<bool> visited;

void dfs(int &cost, int start) {
    visited[start] = true;
    for (const auto &child : adj[path[start]])
        if (start + 1 < path.size() && child.first == path[start + 1])
            dfs(cost += child.second, start + 1);
}

int main() {
    int N, M, K, a, b, w, cost(0);
    cin >> N >> M;

    adj.assign(N, vector<pii>());

    while (M--) {
        cin >> a >> b >> w;
        adj[a].emplace_back(b, w);
        adj[b].emplace_back(a, w);
    }

    cin >> K;

    visited.assign(K, false);
    path.assign(K, 0);

    for (a = 0; a < K; ++a)
        cin >> path[a];
    
    dfs(cost, 0);

    for (a = 0; a < K; ++a)
        if (!visited[a])
            return cout << "-1", 0;
    return cout << cost, 0;
}
