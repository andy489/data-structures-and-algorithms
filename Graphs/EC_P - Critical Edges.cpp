// github.com/andy489

// https://www.spoj.com/problems/EC_P/

// Additional: https://codeforces.com/blog/entry/68138

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

int n, m, timer;

vector<bool> vis;
vector<int> tin, low;
vector<list<int>> adj;

// tin = time of entry into node
// low -> none of the vertices child and its descendants in the DFS traversal tree
// has a back-edge to vertex v or any of its ancestors (v, child)

set<pii> ans;

void tarjan(int u = 1, int p = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;
    for (const auto &child : adj[u]) {
        if (child == p) continue;
        if (vis[child]) low[u] = min(low[u], tin[child]);
        else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);
            if (low[child] > tin[u])
                ans.insert({min(child, u), max(child, u)});
        }
    }
}

int main() {
    ios;
    int t, a, b;
    cin >> t;
    for (int i = 1; i <= t; ++i) {
        cin >> n >> m;
        adj.assign(n + 1, list<int>());
        vis.assign(n + 1, false);
        tin.assign(n + 1, 0);
        low.assign(n + 1, 0);
        while (m--) {
            cin >> a >> b;
            adj[a].pb(b);
            adj[b].pb(a);
        }
        cout << "Caso #" << i << '\n';
        tarjan();
        if (ans.size()) {
            cout << ans.size() << '\n';
            for (const pii &e: ans)
                cout << e.f << ' ' << e.s << '\n';
        } else
            cout << "Sin bloqueos\n";
        ans.clear();
    }
    return 0;
}
