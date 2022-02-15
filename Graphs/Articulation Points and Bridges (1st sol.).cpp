// https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/

#include <cstdio>
#include <vector>
#include <list>
#include <set>

using namespace std;

int n;
vector<bool> vis;
vector<int> tin, low;
vector<list<int>> adj;

set<int> articulation_points;
set<pair<int, int>> bridges;

int timer;

void tarjan(int u = 0, int p = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;

    int children = 0;
    for (int child: adj[u]) {
        if (child == p) {
            continue;
        }

        if (vis[child]) {
            low[u] = min(low[u], tin[child]);
        } else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);

            if (low[child] > tin[u]) {
                bridges.insert({min(u, child), max(u, child)});
            }

            if (low[child] >= tin[u] && p != -1) {
                articulation_points.insert(u);
            }

            ++children;
        }
    }
    
    if (p == -1 && children > 1) {
        articulation_points.insert(u);
    }
}

void init() {
    int m;
    scanf("%d %d", &n, &m);

    adj.resize(n);
    vis.resize(n);
    tin.resize(n);
    low.resize(n);

    int u, v;
    while (m--) {
        scanf("%d %d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
}

int main() {
    init();
    tarjan();

    printf("%lu\n", articulation_points.size());

    for (const auto &art_pt: articulation_points) {
        printf("%d ", art_pt);
    }

    printf("\n%lu\n", bridges.size());

    for (const pair<int, int> &bridge: bridges) {
        printf("%d %d\n", bridge.first, bridge.second);
    }

    return 0;
}
