// github.com/andy489

// https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/

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
        if (u > rhs.u)
            return false;
        else if (u == rhs.u)
            return v < rhs.v;
        else
            return true;
    }
};

vector<list<int>> adj;
vector<int> vis, tin, low;

int timer;

set<int> artPts;
set<Edge> bridges;

void dfs(int u, int par = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;
    int children = 0;
    for (const auto &child: adj[u]) {
        if (child == par)
            continue;
        if (vis[child])
            low[u] = min(low[u], tin[child]);
        else {
            dfs(child, u);
            low[u] = min(low[u], low[child]);
            if (low[child] > tin[u])
                bridges.insert(Edge(u, child));
            if (low[child] >= tin[u] && par != -1)
                artPts.insert(u);
            ++children;
        }
    }
    if (par == -1 && children > 1)
        artPts.insert(u);
}

int main() {
    int n, m, u, v;
    cin >> n >> m;

    adj.resize(n);
    vis.resize(n);
    tin.resize(n);
    low.resize(n);

    while (m--) {
        cin >> u >> v;
        adj[u].pb(v);
        adj[v].pb(u);
    }

    dfs(0);

    cout << artPts.size() << '\n';
    for (const auto &pt: artPts)
        cout << pt << ' ';
    cout << '\n';
    cout << bridges.size() << '\n';
    for (const auto e: bridges)
        cout << e.u << ' ' << e.v << '\n';
}
