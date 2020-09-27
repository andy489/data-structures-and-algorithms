#include <iostream>
#include <vector>
#include <list>
#include <set>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)
#define pb push_back
#define f first
#define s second

typedef pair<int, int> pii;

int timer;

vector<bool> vis;
vector<int> tin, low;
vector<list<int>> adj;

set<int> artPts;
set<pii> bridges;

void tarjan(int u = 0, int p = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;
    int children = 0;
    for (const int &child: adj[u]) {
        if (child == p) continue;
        if (vis[child]) low[u] = min(low[u], tin[child]);
        else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);
            if (low[child] > tin[u])
                bridges.insert({min(u, child), max(u, child)});
            if (low[child] >= tin[u] && p != -1)
                artPts.insert(u);
            ++children;
        }
    }
    if (p == -1 && children > 1)
        artPts.insert(u);
}

int main() {
    ios;
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

    tarjan();

    cout << artPts.size() << '\n';
    for (const auto &pt: artPts)
        cout << pt << ' ';
    cout << '\n';
    cout << bridges.size() << '\n';
    for (const pii& e: bridges)
        cout << e.f << ' ' << e.s << '\n';

    return 0;
}
