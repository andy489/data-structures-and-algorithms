#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<bool> vis;

void dfs(int s, bool &cycle) {
    if (vis[s]) {
        cycle = true;
        return;
    }

    vis[s] = true;

    for (const auto &x : adj[s]) {
        dfs(x, cycle);
    }

    vis[s] = false;
}

int main() {
    int q;
    cin >> q;

    int n, m;
    while (q--) {


        cin >> n >> m;
        adj.assign(n, list<int>());
        vis.assign(n, false);

        int xi, yi, wi;
        while (m--) {
            cin >> xi >> yi >> wi;
            adj[xi - 1].push_back(yi - 1);
        }

        bool cycle = false;
        for (int i = 0; i < n; ++i) { // O(n^2)
            dfs(i, cycle);
            if (cycle) {
                break;
            }
        }

        cout << (cycle ? "true " : "false ");
    }
    return 0;
}
