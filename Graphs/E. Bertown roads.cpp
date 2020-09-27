// github.com/andy489
 
// https://codeforces.com/contest/118/problem/E
 
// Additional: https://codeforces.com/blog/entry/68138
 
#include <iostream>
#include <vector>
#include <list>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)
#define pb push_back
#define pii pair<int, int>
#define f first
#define s second

int n, m;

vector<list<int>> adj;
vector<bool> vis;
vector<int> tin, low;
vector<pii > de;

void tarjan(int u = 1, int p = -1) {
    vis[u] = true;
    tin[u] = low[u] = m++;
    for (const int &child: adj[u]) {
        if (child == p) continue;
        if (vis[child]) {
            low[u] = min(low[u], tin[child]);
            if (tin[child] < tin[u]) // back edge
                de.emplace_back(u, child);
        } else {
            de.emplace_back(u, child);
            tarjan(child, u);
            low[u] = min(low[u], low[child]);
            if (low[child] > tin[u])
                cout << 0, exit(0); // the graph contains bridges
        }
    }
}

int main() {
    ios;
    cin >> n >> m;

    adj.resize(n + 1);
    vis.resize(n + 1);
    tin.resize(n + 1);
    low.resize(n + 1);
    de.reserve(m);
    
    int a, b;
    while (m--) {
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }

    tarjan();

    for(const pii&e:de)
        cout<<e.f<<' '<<e.s<<'\n';

    return 0;
}
