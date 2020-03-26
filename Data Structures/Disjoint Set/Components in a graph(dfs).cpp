// github.com/andy489

//DFS
#include <bits/stdc++.h>
using namespace std;

vector<unordered_set<int>>adj;
vector<bool>visited;

void dfs(int start, int& count) {
    visited[start] = true;
    ++count;
    for (const auto& child : adj[start]) {
        if (!visited[child]) {
            dfs(child, count);
        }
    }
}

int main() {
    int n, i, a, b;
    cin >> n;

    adj.assign(2 * n, unordered_set<int>());
    visited.assign(2 * n, false);

    for (i = 0;i < n;++i) {
        cin >> a >> b;--a;--b;
        adj[a].insert(b);
        adj[b].insert(a);
    }
    int minComponent(2 * n), maxComponent(2);
    for (i = 0;i < n;++i) {
        if (!visited[i] && adj[i].size() > 0) {
            int count(0);
            dfs(i, count);
            minComponent = min(count, minComponent);
            maxComponent = max(count, maxComponent);
        }
    }
    cout << minComponent << ' ' << maxComponent;
    return 0;
}
