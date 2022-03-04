// https://www.hackerrank.com/contests/test7-sda-soft-eng/challenges/challenge-1771/problem

#include <iostream>
#include <vector>
#include <list>
#include <unordered_map>

using namespace std;

vector<list<pair<int, int>>> adj;
vector<bool> vis;

unordered_map<int, int> cost_cnt_map;

int k;

void dfs(int v, int length, int cost) {
    if (length == k) {
        ++cost_cnt_map[cost];
        return;
    }

    vis[v] = true;

    for (const auto &p : adj[v]) {
        int child = p.first;
        int weight = p.second;

        if (!vis[child]) {
            dfs(child, length + 1, cost + weight);
        }
    }

    vis[v] = false;
}

int main() {
    int n, m;
    cin >> n >> m;

    adj.resize(n, list<pair<int, int>>());
    vis.resize(n, false);

    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;
        adj[u - 1].push_back({v - 1, w});
    }

    cin >> k;

    for (int i = 0; i < n; ++i) {
        dfs(i, 0, 0);
    }

    int cost = -1;
    int times = 0;

    for (const auto &kvp : cost_cnt_map) {
        int cur_cost = kvp.first;
        int cur_times = kvp.second;

        if (cur_times > times || (cur_times == times && cur_cost > cost)) {
            cost = cur_cost;
            times = cur_times;
        }
    }

    cout << cost;
    
    return 0;
}
