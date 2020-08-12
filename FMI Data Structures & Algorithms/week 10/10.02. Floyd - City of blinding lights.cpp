// github.com/andy489

// https://www.hackerrank.com/contests/practice-9-sda/challenges/floyd-city-of-blinding-lights

#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <climits>

using namespace std;

void dijkstra(vector<unordered_map<int, int>> &adj, int s, int e, vector<vector<pair<int, bool>>> &t) {
    if (t[s][e].second)
        cout << t[s][e].first << '\n';
    else {
        vector<bool> visited(adj.size());
        vector<int> paths(adj.size(), INT_MAX);
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
        int i(1);
        for (; i < adj.size(); ++i) {
            if (paths[i] != INT_MAX)
                t[s][i] = {paths[i], true};
            else
                t[s][i] = {-1, true};
        }

        if (paths[e] != INT_MAX)
            cout << paths[e] << "\n";
        else
            cout << -1 << "\n";
    }
}

int main() {
    int V, E, u, v, w;
    cin >> V >> E;

    vector<unordered_map<int, int >> adj(V + 1);

    while (E--) {
        cin >> u >> v >> w;
        if (!adj[u].count(v))
            adj[u][v] = w;
        else
            adj[u].erase(v), adj[u][v] = w;
    }

    vector<vector<pair<int, bool>>> t(V + 1, vector<pair<int, bool>>(V + 1, {-1, false}));

    int q;
    cin >> q;
    int s, e;
    while (q--) {
        cin >> s >> e;
        dijkstra(adj, s, e, t);
    }
}
