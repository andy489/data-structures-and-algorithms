// https://www.hackerrank.com/contests/practice-9-sda/challenges/floyd-city-of-blinding-lights

#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

const int INF = 1e9;

void dijkstra(vector<unordered_map<int, int>> &adj, int s, int e, vector<vector<pair<int, bool>>> &t) {
    if (t[s][e].second) {
        cout << t[s][e].first << endl;
    } else {
        vector<bool> visited(adj.size());
        vector<int> paths(adj.size(), INF);
        paths[s] = 0;

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        q.push({0, s});

        while (!q.empty()) {
            pair<int, int> cur = q.top();
            q.pop();

            visited[cur.second] = true;

            for (const auto &x: adj[cur.second]) {
                if (!visited[x.first] && paths[cur.second] + x.second < paths[x.first]) {
                    paths[x.first] = x.second + paths[cur.second];
                    q.push({paths[x.first], x.first});
                }
            }
        }

        const int SIZE = adj.size();
        for (int i = 1; i < SIZE; ++i) {
            if (paths[i] != INF) {
                t[s][i] = {paths[i], true};
            } else {
                t[s][i] = {-1, true};
            }
        }

        if (paths[e] != INF) {
            cout << paths[e] << endl;
        } else {
            cout << -1 << endl;
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    vector<unordered_map<int, int >> adj(n + 1);

    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;

        if (!adj[u].count(v)) {
            adj[u][v] = w;
        } else {
            adj[u].erase(v);
            adj[u][v] = w;
        }
    }

    vector<vector<pair<int, bool>>> t(n + 1, vector<pair<int, bool>>(n + 1, {-1, false}));

    int q;
    cin >> q;

    int s, e;
    while (q--) {
        cin >> s >> e;
        dijkstra(adj, s, e, t);
    }
}
