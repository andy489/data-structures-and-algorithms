// https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=551

#include <cstdio>
#include <vector>
#include <list>
#include <set>

using namespace std;

int timer;

vector<list<int>> adj;
vector<bool> vis; // visited
vector<int> tin; // time of entry into node
vector<int> low; // low[v] = min{tin[v], tin[par], low[to]},
// for all par for which (v, par) is a back edge, for all to for which (v, to) is a tree edge

set<pair<int, int>> dfs_spanning_edges;
set<pair<int, int>> back_edges;
set<pair<int, int>> bridges;

void tarjan(int u = 1, int par = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;

    if (par != -1) {
        dfs_spanning_edges.insert({par, u});
    }

    for (const int &child : adj[u]) {
        if (child == par) {
            continue;
        }

        if (vis[child]) {
            low[u] = min(low[u], tin[child]);
            if (back_edges.find({child, u}) == back_edges.end()) {
                back_edges.insert({u, child});
            }
        } else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);

            if (low[child] > tin[u]) {
                bridges.insert({u, child});
            }
        }
    }
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    int test_case = 1;
    while (n != 0 && m != 0) {
        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, false);
        tin.assign(n + 1, 0);
        low.assign(n + 1, 0);

        int a, b;
        while (m--) {
            scanf("%d %d", &a, &b);
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        tarjan();

        printf("%d\n\n", test_case);

        for (const auto &sp:dfs_spanning_edges) {
            printf("%d %d\n", sp.first, sp.second);
            if (!bridges.empty()) {
                if (bridges.find(sp) != bridges.end()) {
                    printf("%d %d\n", sp.second, sp.first);
                    bridges.erase(sp);
                }
            }
        }

        for (const auto &be:back_edges) {
            printf("%d %d\n", be.first, be.second);
        }

        printf("#\n");

        scanf("%d %d", &n, &m);
        timer = 0;
        test_case++;
        dfs_spanning_edges.clear();
        back_edges.clear();
        bridges.clear();
    }
}

/*
7 10
1 2
1 3
2 4
3 4
4 5
4 6
5 7
6 7
2 5
3 6
7 9
1 2
1 3
1 4
2 4
3 4
4 5
5 6
5 7
7 6
0 0
*/
