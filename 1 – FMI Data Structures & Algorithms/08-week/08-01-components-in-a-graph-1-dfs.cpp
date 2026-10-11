// https://www.hackerrank.com/contests/sda-hw-10/challenges/components-in-graph/problem

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<bool> vis;

int dfs(int u) {
    if(vis[u]){
        return 1;
    }

    vis[u] = true;
    int cnt_nodes = 1;

    for (int child : adj[u]) {
        if (!vis[child]) {
            cnt_nodes += dfs(child);
        }
    }

    return cnt_nodes;
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

    int mini = N;
    int maxi = -1;
    for (int v = 1; v <= N; ++v) {
        if (!vis[v]) {
            int cnt = dfs(v);

            if(cnt == 1){
                continue;
            }

            mini = min(mini, cnt);
            maxi = max(maxi, cnt);
        }
    }

    cout << mini << ' ' << maxi;

    return 0;
}