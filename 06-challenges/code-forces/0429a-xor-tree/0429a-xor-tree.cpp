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

    for (int child:adj[s]) {
        if (!vis[child]) {
            dfs(child, c2, c1);
        }
    }
}

int main() {
    int n;
    cin >> n;

    adj.resize(n + 1);
    vis.resize(n + 1);
    init.resize(n + 1);
    goal.resize(n + 1);

    int u, v;
    for (int i = 0; i < n - 1; ++i) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i <= n; ++i) {
        cin >> init[i];
    }

    for (int i = 1; i <= n; ++i) {
        cin >> goal[i];
    }

    dfs(1, 0, 0);

    cout << cnt.size() << endl;

    for (int c:cnt) {
        cout << c << endl;
    }

    return 0;
}
