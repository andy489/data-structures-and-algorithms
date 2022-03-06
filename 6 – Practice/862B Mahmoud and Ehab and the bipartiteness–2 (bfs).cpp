// https://codeforces.com/problemset/problem/862/B

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<long>> adj;
vector<bool> vis;

long bfs(int u = 1, int lvl = 1) {
    int odd = 0;
    list<int> q;

    vis[u] = true;
    q.push_back(u);

    while (!q.empty()) {
        int curr_size = q.size();

        if (lvl & 1) {
            odd += curr_size;
        }

        while (curr_size--) {
            int curr = q.front();
            q.pop_front();

            for (int child: adj[curr]) {
                if (!vis[child]) {
                    vis[child] = true;
                    q.push_back(child);
                }
            }
        }

        ++lvl;
    }

    return odd;
}

int main() {
    int n;
    cin >> n;

    adj.resize(n + 1);
    vis.resize(n + 1);

    int u, v;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int odd = bfs();

    cout << (long long) (n - odd) * odd - n + 1;

    return 0;
}
