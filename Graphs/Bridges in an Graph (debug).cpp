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

    adj.resize(n + 1);
    vis.resize(n + 1);
    tin.resize(n + 1);
    low.resize(n + 1);

    int a, b;
    while (m--) {
        scanf("%d %d", &a, &b);
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    tarjan();

    printf("bridges: %lu\n", bridges.size());
    for (const auto &br:bridges) {
        printf("%d %d\n", br.first, br.second);
    }
    printf("dfs spanning edges: %lu\n", dfs_spanning_edges.size());
    for (const auto &sp:dfs_spanning_edges) {
        printf("%d %d\n", sp.first, sp.second);
    }
    printf("back edges: %lu\n", back_edges.size());
    for (const auto &be:back_edges) {
        printf("%d %d\n", be.first, be.second);
    }

    printf("Total edges: %lu\n(bridges are spanning edges)", dfs_spanning_edges.size() + back_edges.size());
}

/*
12 16
9 12
10 4
9 1
5 1
2 6
7 3
5 7
6 3
8 2
1 6
3 1
2 4
3 8
11 9
12 11
5 3
*/
