// github.com/andy489

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

        for (const int &child:adj[curr])
            if (!vis[child]) {
                q.push(child);
                vis[child] = true;
                dist[child] = dist[curr] + 6;
            }
    }
}

int main() {
    int q, n, m, a, b, start, i;
    cin >> q;
    while (q--) {
        cin >> n >> m;

        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, false);
        dist.assign(n + 1, -1);

        for (i = 0; i < m; ++i) {
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        cin >> start;

        bfs(start);

        for (i = 1; i <= n; ++i)
            if (i != start)
                cout << dist[i] << " ";
        cout << "\n";
    }
    return 0;
}
