// github.com/andy489
 
// https://codeforces.com/contest/118/problem/E
 
// Additional: https://codeforces.com/blog/entry/68138
 
#include <iostream>
#include <vector>
#include <list>
 
using namespace std;
 
#define ios ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)
#define pb push_back
#define pii pair<int,int>
 
vector<list<int>> adj;
vector<bool> vis;
vector<int> tin, low;
 
int timer;
 
vector<pii > de; // directed edges

// we will direct all span edges downwаrds and all back edges upwаrds
void dfs(int u, int par = -1) {
    vis[u] = true;
    tin[u] = low[u] = timer++;
    for (const auto &child: adj[u]) {
        if (child == par)
            continue;
        if (vis[child]) {
            low[u] = min(low[u], tin[child]);
            if (tin[child] < tin[u]) // back edge
                de.emplace_back(u, child);
        } else {
            de.emplace_back(u, child);
            dfs(child, u);
            low[u] = min(low[u], low[child]);
            if (low[child] > tin[u]) {
                cout << 0; // if the graph contains bridges this is impossible
                exit(0);
            }
        }
    }
}
 
int main() {
    ios;
    int n, m, u, v;
    cin >> n >> m;
 
    adj.resize(n + 1);
    vis.resize(n + 1);
    tin.resize(n + 1);
    low.resize(n + 1);
    de.reserve(m);
    
    while (m--) {
        cin >> u >> v;
        adj[u].pb(v);
        adj[v].pb(u);
    }
 
    dfs(1);
 
    for (const auto &e: de)
        cout << e.first << ' ' << e.second << '\n';
 
    return 0;
}
