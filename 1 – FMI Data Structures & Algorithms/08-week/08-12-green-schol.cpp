// https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2299

#include <iostream>
#include <vector>
#include <list>
#include <queue>
#include <set>

using namespace std;

int k, sz, lvl;

vector<list<int>> adj;
vector<bool> vis;
set<int> k_dist_cities;

void bfs(int u) {
    queue<int> q;
    q.push(u);

    vis[u] = true;
    sz = 1;

    while (!q.empty()) {
        auto curr = q.front();
        q.pop();

        --sz;
        for (int child : adj[curr]) {
            if (!vis[child]) {
                if (lvl == k - 1) {
                    k_dist_cities.insert(child);
                }

                q.push(child);
                vis[child] = true;
            }
        }

        if (!sz) {
            sz = q.size();
            ++lvl;

            if (lvl >= k) {
                return;
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m >> k;

    adj.resize(n + 1);
    vis.resize(n + 1);

    int u, v;
    while (m--) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    bfs(n);

    if (k == 0) {
        cout << n;
    } else if (k_dist_cities.empty()) {
        cout << "-1";
    } else {
        for (int city : k_dist_cities) {
            cout << city << ' ';
        }
    }

    return 0;
}