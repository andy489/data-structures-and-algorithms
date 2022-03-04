// https://www.hackerrank.com/challenges/journey-to-the-moon/problem

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> adj;
vector<int> vis;

int bfs(int s) {
    queue<int> q;
    q.push(s);

    vis[s] = true;

    int cnt = 1;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (int child:adj[curr]) {
            if (!vis[child]) {
                q.push(child);
                vis[child] = true;
                ++cnt;
            }
        }
    }

    return cnt;
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
        adj[v].push_back(u);
    }

    vector<int> components;

    for (int i = 0; i < n; ++i) {
        if (!vis[i]) {
            int curr_comp_cnt = bfs(i);
            components.push_back(curr_comp_cnt);
        }
    }

    long long sum = (long long) n * n;

    for (int c:components) {
        sum -= c * c;;
    }

    cout << sum / 2;

    return 0;
}