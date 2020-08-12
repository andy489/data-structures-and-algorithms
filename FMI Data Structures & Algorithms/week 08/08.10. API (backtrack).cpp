// github.com/andy489

// https://www.hackerrank.com/contests/test7-sda-soft-eng/challenges/challenge-1771/problem

#include <iostream>
#include <vector>
#include <list>
#include <unordered_map>

using namespace std;

typedef pair<int, int> pii;

vector<list<pair<int, int>>> adj;
vector<bool> vis;

unordered_map<int, int> um;

int k;

void dfs(int v, int length, int cost) {
    if (length == k) {
        ++um[cost];
        return;
    }
    
    vis[v] = true;
    
    for (const auto &p : adj[v]) {
        int child = p.first;
        int weight = p.second;

        if (!vis[child])
            dfs(child, length + 1, cost + weight);
    }
    vis[v] = false;
}

int main() {
    int V, E, u, v, w, i(0);
    cin >> V >> E;

    adj.assign(V, list<pii>());
    vis.assign(V, false);

    while (E--) {
        cin >> u >> v >> w;
        --u, --v;
        adj[u].push_back({v, w});
    }

    cin >> k;

    for (; i < V; ++i)
        dfs(i, 0, 0);

    int cost(-1), times(0);

    for (const auto &kvp : um) {
        int cur_cost = kvp.first;
        int cur_times = kvp.second;

        if (cur_times > times || (cur_times == times && cur_cost > cost)) {
            cost = cur_cost;
            times = cur_times;
        }
    }
    return cout << cost, 0;
}
