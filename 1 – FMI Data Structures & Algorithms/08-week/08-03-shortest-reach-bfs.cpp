// https://www.hackerrank.com/challenges/bfsshortreach/problem

#include <iostream>
#include <vector>
#include <list>
#include <queue>

using namespace std;

vector<list<int>> adj;
vector<bool> vis;
vector<int> dist;

void bfs(int s) {
    queue<int> q;
    q.push(s);

    vis[s] = true;
    dist[s] = 0;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (int child:adj[curr]) {
            if (!vis[child]) {
                q.push(child);
                vis[child] = true;
                dist[child] = dist[curr] + 6;
            }
        }
    }
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n, m;
        cin >> n >> m;

        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, false);
        dist.assign(n + 1, -1);

        int a, b;
        while (m--) {
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        int start;
        cin >> start;

        bfs(start);

        for (int i = 1; i <= n; ++i) {
            if (i == start) {
                continue;
            }

            cout << dist[i] << " ";
        }

        cout << endl;
    }

    return 0;
}
