// https://www.spoj.com/problems/EC_P/
// https://codeforces.com/blog/entry/68138

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

set<pair<int, int>> bridges;

void tarjan(int u = 1, int par = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;

    for (const auto &child : adj[u]) {
        if (child == par) {
            continue;
        }

        if (vis[child]) {
            low[u] = min(low[u], tin[child]);
        } else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);

            if (low[child] > tin[u]) {
                bridges.insert({min(child, u), max(child, u)});
            }
        }
    }
}

int main() {
    int t;
    scanf("%d", &t);

    int n, m;
    for (int i = 1; i <= t; ++i) {
        scanf("%d %d", &n, &m);

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

        printf("Caso #%d\n", i);

        tarjan();

        if (bridges.empty()) {
            printf("Sin bloqueos\n");
        } else {
            printf("%lu\n", bridges.size());

            for (const auto &br: bridges) {
                printf("%d %d\n", br.first, br.second);
            }
        }

        bridges.clear();
        timer = 0;
    }

    return 0;
}
