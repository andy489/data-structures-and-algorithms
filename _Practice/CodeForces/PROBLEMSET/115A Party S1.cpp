// github.com/andy489

// https://codeforces.com/problemset/problem/115/A

#include <iostream>
#include <vector>

using namespace std;

vector<bool> boss;
vector<vector<int>> adj;

int maxDepth = 0;

void dfs(int u, int depth = 0) {
    maxDepth = (depth > maxDepth ? depth : maxDepth);
    for (auto x: adj[u])
        dfs(x, depth + 1);
}

int main() {
    int n, m; // m = manager
    cin >> n;
    adj.assign(n, vector<int>());
    boss.assign(n, false);

    for (int e = 0; e < n; ++e) { // e = employee
        cin >> m;
        if (m != -1)
            adj[--m].push_back(e);
        else
            boss[e] = true;
    }

    for (int i = 0; i < n; ++i) {
        if (boss[i])
            dfs(i);
    }

    cout << ++maxDepth;

    return 0;
}
