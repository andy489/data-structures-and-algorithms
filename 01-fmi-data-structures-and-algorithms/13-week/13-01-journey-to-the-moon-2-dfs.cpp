// https://www.hackerrank.com/challenges/journey-to-the-moon/problem

#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> adj;
vector<int> vis;

int dfs(int u) {
    if (vis[u]) {
        return 1;
    }

    vis[u] = true;
    int cnt = 1;

    for (int child:adj[u]) {
        if (!vis[child]) {
            cnt += dfs(child);
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
            int curr_comp_cnt = dfs(i);
            components.push_back(curr_comp_cnt);
        }
    }

    long long sum = 0;
    long long res = 0;

    for (int c:components) {
        res += sum * c;
        sum += c;
    }

    cout << res;

    return 0;
}