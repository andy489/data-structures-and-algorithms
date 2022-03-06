// https://codeforces.com/problemset/problem/115/A

#include <iostream>
#include <vector>

using namespace std;

vector<bool> boss;
vector<vector<int>> adj;

int max_depth = 0;

void dfs(int u, int depth = 0) {
    max_depth = (depth > max_depth ? depth : max_depth);

    for (int child: adj[u]) {
        dfs(child, depth + 1);
    }
}

int main() {
    int n, m; // m = manager
    cin >> n;

    adj.resize(n);
    boss.resize(n);

    for (int e = 0; e < n; ++e) { // e = employee
        cin >> m;

        if (m != -1) {
            adj[--m].push_back(e);
        } else {
            boss[e] = true;
        }
    }

    for (int i = 0; i < n; ++i) {
        if (boss[i]) {
            dfs(i);
        }
    }

    cout << ++max_depth;

    return 0;
}