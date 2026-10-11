// https://www.hackerrank.com/contests/practice-8-sda/challenges/discos

#include <iostream>
#include <vector>
#include <list>
#include <queue>

using namespace std;

const int MAX = 1e9;

vector<list<pair<int, int>>> adj;
vector<bool> vis;
vector<int> paths;

void dijkstra(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
    q.push({0, start});
    paths[start] = 0;

    while (!q.empty()) {
        auto curr_node = q.top();
        q.pop();

        int v = curr_node.second;

        if (vis[v]) {
            continue;
        }

        vis[v] = true;

        for (const auto &child : adj[v]) {
            if (vis[child.second]) {
                continue;
            }

            if (paths[v] + child.first < paths[child.second]) {
                paths[child.second] = paths[v] + child.first;
                q.push({paths[child.second], child.second});
            }
        }
    }
}


int main() {
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);
    vis.resize(n + 1);
    paths.assign(n + 1, MAX);

    int u, v, w;
    while (m--) { // m = edges
        cin >> u >> v >> w;
        adj[u].push_back({w, v});
        adj[v].push_back({w, u});
    }

    cin >> m;

    while (m--) { // m = discos
        cin >> u;
        adj[u].push_back({0, n});
        adj[n].push_back({0, u});
    }

    dijkstra(n); // n is the fake node connected to all disco nodes with 0 weighted edges

    cin >> m;

    int student;
    while (m--) { // m = queries
        cin >> student;
        cout << paths[student] << endl;
    }

    return 0;
}
