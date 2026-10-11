// https://www.hackerrank.com/contests/test6-sda/challenges/challenge-1761/problem

#include <iostream>
#include <vector>
#include <list>

using namespace std;

int n, m;

vector<list<int>> adj;
vector<bool> vis;

int dfs(int u, int &cnt) {
    int cnt_nodes = 0;
    vis[u] = true;

    for (int child : adj[u]) {
        if (!vis[child]) {
            int subtree_node_cnt = dfs(child, cnt);

            if (subtree_node_cnt & 1) { // odd
                cnt_nodes += subtree_node_cnt;
            } else {
                ++cnt;
            }
        }
    }
    
    return cnt_nodes + 1;
}

int main() {
    cin >> n >> m;

    adj.resize(n + 1, list<int>());
    vis.resize(m + 1, false);

    int u, v;
    while (m--) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int removed_edges_cnt = 0;
    dfs(n, removed_edges_cnt);

    cout << removed_edges_cnt;

    return 0;
}
