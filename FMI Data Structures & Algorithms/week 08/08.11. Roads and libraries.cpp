// github.com/andy489

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
    for (const auto &child : adj[s])
        if (!vis[child])
            dfs(child, cnt);
}

int main() {
    int q, V, E, c_road, c_lib, i(1), a, b, numCitiesInComp(0);

    long ans1(0), ans2(0);

    cin >> q;
    while (q--) {
        cin >> V >> E >> c_lib >> c_road;

        adj.assign(V + 1, list<int>());
        vis.assign(V + 1, 0);
        regions.clear();

        while (E--) {
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        for (i = 1; i <= V; ++i)
            if (!vis[i]) {
                dfs(i, numCitiesInComp);
                regions.push_back(numCitiesInComp);
                numCitiesInComp = 0;
            }

        for (const auto &x : regions) {
            ans1 += c_lib + (x - 1) * c_road;
            ans2 += x * c_lib;
        }

        cout << min(ans1, ans2) << '\n';
        ans1 = 0, ans2 = 0;
    }
    return 0;
}
