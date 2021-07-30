// github.com/andy489

// https://codeforces.com/problemset/problem/429/A

#include<iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<int> init, goal, cnt, vis;

void dfs(int s, int c1, int c2) {
    vis[s] = true;
    if (init[s] ^ c1 != goal[s]) {
        c1 ^= 1;
        cnt.push_back(s);
    }
    for (auto x:adj[s]) {
        if (!vis[x])
            dfs(x, c2, c1);
    }
}

int main() {
    int n, i, u, v;
    cin >> n;

    adj.assign(n + 1, list<int>());
    vis.assign(n + 1, false);
    init.resize(n + 1);
    goal.resize(n + 1);

    for (i = 0; i < n - 1; ++i) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for (i = 1; i <= n; ++i)
        cin >> init[i];
    for (i = 1; i <= n; ++i)
        cin >> goal[i];
    dfs(1, 0, 0);
    cout << cnt.size() << '\n';
    for (auto x:cnt)
        cout << x << '\n';
    return 0;
}
