// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/shortest-tour/problem

#include <iostream>
#include <list>
#include <queue>

using namespace std;

vector<list<int>> adj;
vector<bool> vis;

int bfs(int start, int end) {
    queue<int> q;
    q.push(start);
    vis[start] = true;

    int lvl = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int curr = q.front();
            vis[curr] = true;

            if (curr == end) {
                return lvl;
            }

            for (int child : adj[curr]) {
                if (!vis[child]) {
                    q.push(child);
                }
            }

            q.pop();
        }

        ++lvl;
    }

    return -1;
}

int main() {
    int n, m;
    cin >> n >> m;

    adj.resize(n);
    vis.resize(n);

    int u, v;
    while (m--) {
        cin >> u >> v;
        adj[u].push_back(v);
    }

    int k;
    cin >> k;

    vector<int> path(k);

    for (int i = 0; i < k; ++i) {
        cin >> path[i];
    }

    int shortest_path = 0;

    for (int i = 0; i < k - 1; ++i) {
        for (int j = i + 2; j < k; ++j) {
            vis[path[j]] = true; // mark the forbidden nodes
        }

        int dist = bfs(path[i], path[i + 1]);

        vis.assign(n, false);

        if (dist != -1) {
            shortest_path += dist;
        } else {
            shortest_path = dist;
            break;
        }
    }

    cout << shortest_path;

    return 0;
}
