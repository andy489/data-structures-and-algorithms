#include <iostream>
#include <vector>
#include <list>
#include <set>

using namespace std;

#define pb push_back

struct Edge {
    int u, v;

    Edge(int u, int v) {
        if (u > v) swap(u, v);
        this->u = u, this->v = v;
    }

    bool operator<(const Edge &rhs) const {
        if (this->u > rhs.u)
            return false;
        else if (this->u == rhs.u)
            return this->v < rhs.v;
        else
            return true;
    }
};

vector<list<int>> adj;
vector<bool> vis;
vector<int> tin, low;
set<Edge> dfs_spanning_edges, back_edges, bridges;

int timer;

void dfs(int u, int par = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;
    if (par != -1)
        dfs_spanning_edges.insert(Edge(u, par));
    for (const auto &child:adj[u]) {
        if (child == par)
            continue;
        if (!vis[child]) {
            dfs(child, u);
            low[u] = min(low[u], low[child]);
            if (low[child] > tin[u])
                bridges.insert(Edge(u, child));
        } else {
            low[u] = min(low[u], tin[child]);
            back_edges.insert(Edge(u, child));
        }
    }
}

int main() {
    int n, m, u, v;
    cin >> n >> m;

    adj.resize(n + 1);
    vis.resize(n + 1);
    tin.resize(n + 1);
    low.resize(n + 1);

    while (m--) {
        cin >> u >> v;
        adj[u].pb(v);
        adj[v].pb(u);
    }

    dfs(1);
    cout << "dfs spanning edges: " << dfs_spanning_edges.size() << '\n';
    for (const auto &e:dfs_spanning_edges)
        cout << e.u << ' ' << e.v << '\n';
    cout << "back edges: " << back_edges.size() << '\n';
    for (const auto &e: back_edges)
        cout << e.u << ' ' << e.v << '\n';
    cout << "bridges: " << bridges.size() << '\n';
    for (const auto &e: bridges)
        cout << e.u << ' ' << e.v << '\n';

    return 0;
}

/*
example 1
8 10
1 2
1 3
2 3
1 4
4 5
4 6
4 8
6 8
6 7
3 5

example 2
8 9
1 2
1 3
2 3
1 4
4 5
4 6
4 8
6 8
6 7
*/
