// github.com/andy489

// https://www.hackerrank.com/contests/test6-sda/challenges/challenge-1761/problem

#include <iostream>
#include <vector>
#include <list>

using namespace std;

int V, E;

vector<list<int>> adj;
vector<bool> vis;

int dfs(int u, int &ans) {
    int cntNodes = 0;
    vis[u] = true;
    for (const auto &child : adj[u]) {
        if (!vis[child]) {
            int subtreeNodeCount = dfs(child, ans);
            if (!(subtreeNodeCount & 1))
                ++ans;
            else
                cntNodes += subtreeNodeCount;
        }
    }
    return cntNodes + 1;
}

int main() {
    int v1, v2, ans(0);
    cin >> V >> E;

    adj.assign(V + 1, list<int>());
    vis.assign(V + 1, false);

    while (E--) {
        cin >> v1 >> v2;
        adj[v1].push_back(v2);
        adj[v2].push_back(v1);
    }

    dfs(V, ans);

    return cout << ans, 0;
}
