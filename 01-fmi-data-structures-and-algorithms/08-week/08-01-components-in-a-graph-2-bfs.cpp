// https://www.hackerrank.com/contests/sda-hw-10/challenges/components-in-graph/problem

#include <iostream>
#include <vector>
#include <list>
#include <queue>

using namespace std;

vector<list<int>> adj;
vector<bool> vis;

int bfs(int u) {
    int cnt = 0;

    queue<int> q;
    q.push(u);
    vis[u] = true;

    while (!q.empty()) {
        int v = q.front();
        q.pop();
        ++cnt;

        for (int child : adj[v]) {
            if (!vis[child]) {
                vis[child] = true;
                q.push(child);
            }
        }
    }

    return cnt;
}

int main() {
    int n;
    cin >> n;

    int copy_n = n;
    int N = 2 * n;

    adj.resize(N + 1, list<int>());
    vis.resize(N + 1, false);

    int a, b;
    while (copy_n--) {
        cin >> a >> b;

        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    int mini(N);
    int maxi(-1);
    for (int v = 1; v <= N; ++v) {
        if (!vis[v]) {
            int cnt = bfs(v);

            if (cnt == 1) {
                continue;
            }

            mini = min(mini, cnt);
            maxi = max(maxi, cnt);
        }
    }

    cout << mini << " " << maxi;

    return 0;
}