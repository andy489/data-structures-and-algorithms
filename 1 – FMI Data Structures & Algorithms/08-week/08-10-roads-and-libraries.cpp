// https://www.hackerrank.com/challenges/torque-and-development/problem

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<int> vis;
list<int> regions;

void dfs(int s, int &cnt) {
    vis[s] = true;
    ++cnt;

    for (int child : adj[s]) {
        if (!vis[child]) {
            dfs(child, cnt);
        }
    }
}

int main() {
    int q;

    cin >> q;
    while (q--) {
        int n, m, c_lib, c_road;
        cin >> n >> m >> c_lib >> c_road;

        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, 0);
        regions.clear();

        int a,b;
        while (m--) {
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        int num_cities_in_comp = 0;
        for (int i = 1; i <= n; ++i) {
            if (!vis[i]) {
                dfs(i, num_cities_in_comp);
                regions.push_back(num_cities_in_comp);
                num_cities_in_comp = 0;
            }
        }

        long ans1 = 0;
        long ans2 = 0;

        for (const auto &x : regions) {
            ans1 += c_lib + (x - 1) * c_road;
            ans2 += x * c_lib;
        }

        cout << min(ans1, ans2) << endl;
    }
    return 0;
}
