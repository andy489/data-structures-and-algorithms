// github.com/andy489

// https://codeforces.com/problemset/problem/862/B

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<long>> adj;
vector<bool> vis;

long bfs(int u = 1, int lvl = 1) {
    long odd = 0;
    list<int> q; // queue
    vis[u] = true;
    q.push_back(u);

    while (!q.empty()) {
        int sz = q.size();
        if (lvl & 1) {
            odd += sz;
        }
        while (sz--) {
            int curr = q.front();
            q.pop_front();
            for (auto x: adj[curr]) {
                if (!vis[x]) {
                    vis[x] = true;
                    q.push_back(x);
                }
            }
        }
        sz = q.size();
        ++lvl;
    }
    return odd;
}

int main() {
    size_t n, i(1), u, v;
    cin >> n;

    adj.assign(n + 1, list<long>());
    vis.assign(n + 1, false);

    for (; i < n; ++i) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    long odd = bfs();

    return cout << (n - odd) * odd - n + 1, 0;
}
