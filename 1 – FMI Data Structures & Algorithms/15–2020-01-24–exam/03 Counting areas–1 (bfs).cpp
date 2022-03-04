// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2351

#include <iostream>
#include <vector>
#include <list>
#include <queue>

using namespace std;

vector<list<int>> adj;
vector<int> vis;

void bfs(int s) {
    queue<int> q;
    q.push(s);

    vis[s] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int child:adj[cur]) {
            if (!vis[child]) {
                q.push(child);
                vis[child] = true;
            }
        }
    }
}

int main() {
    int q;
    cin >> q;

    while (q--) {
        int n, m;
        cin >> n >> m;

        adj.assign(n, list<int>());
        vis.assign(n, false);

        int u, v;
        while (m--) {
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        int comp = 0;

        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                bfs(i);
                ++comp;
            }
        }

        if (comp) {
            cout << comp << ' ';
        }
    }

    return 0;
}
