// github.com/andy489

// Debug: https://codeforces.com/blog/entry/68138

#include <iostream>
#include <vector>
#include <list>
#include <set>

using namespace std;

#define pb push_back

vector<list<int>> adj;
vector<bool> vis;

vector<int> tin, low;
int timer;

struct Edge {
    int u, v;

    Edge(int u, int v) {
        if (u > v)
            swap(u, v);
        this->u = u;
        this->v = v;
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

set<Edge> dfs_spanning_edges, back_edges, bridges;;

void dfs(int v, int par = -1) {
    vis[v] = true;
    tin[v] = low[v] = timer++;
    if(par!=-1) {
        Edge se(v, par);
        dfs_spanning_edges.insert(se);
    }
    for (const int &child : adj[v]) {
        if (child == par) continue;
        if (vis[child]) {
            low[v] = min(low[v], tin[child]);
            Edge be(v, child);
            back_edges.insert(be);
        } else {
            dfs(child, v);
            low[v] = min(low[v], low[child]);
            if (low[child] > tin[v]){
                Edge br(v, child);
                bridges.insert(br);
            }
        }
    }
}

int main() {
    int n, m;

    n = 12, m = 16;
    adj.assign(n + 1, list<int>());
    vis.assign(n + 1, 0);
    tin.assign(n + 1, 0);
    low.assign(n + 1, 0);

    adj[1].pb(3), adj[1].pb(5), adj[1].pb(6), adj[1].pb(9);
    adj[2].pb(4), adj[2].pb(6), adj[2].pb(8);
    adj[3].pb(1), adj[3].pb(5), adj[3].pb(6), adj[3].pb(7), adj[3].pb(8);
    adj[4].pb(2), adj[4].pb(10);
    adj[5].pb(3), adj[5].pb(1), adj[5].pb(7);
    adj[6].pb(3), adj[6].pb(1), adj[6].pb(2);
    adj[7].pb(5), adj[7].pb(3);
    adj[8].pb(2), adj[8].pb(3);
    adj[9].pb(1), adj[9].pb(11), adj[9].pb(12);
    adj[10].pb(4);
    adj[11].pb(9), adj[11].pb(12);
    adj[12].pb(9), adj[12].pb(11);


    dfs(1); // dfs tree

    cout << "bridges: " << bridges.size() << '\n';
    for (const auto &e:bridges)
        cout << e.u << ' ' << e.v << '\n';
    cout << "dfs spanning edges: " << dfs_spanning_edges.size() << '\n';
    for (const auto &e:dfs_spanning_edges)
        cout << e.u << ' ' << e.v << '\n';
    cout << "back edges: " << back_edges.size() << '\n';
    for (const auto &e:back_edges)
        cout << e.u << ' ' << e.v << '\n';
}

