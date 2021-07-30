// github.com/andy489
 
// https://codeforces.com/problemset/problem/839/C
 
#include<iostream>
#include<vector>
#include <list>
 
using namespace std;
 
#define pb push_back
 
vector<list<int>> adj;
 
double dfs(int u = 1, int pr = -1) {
    double path(0);
    for (const int &child:adj[u])
        if (child != pr)
            path += dfs(child, u) + 1;
    return path ? path / (adj[u].size() - (u != 1)) : 0;
}
 
int main() {
    int n, i(1), u, v;
    cin >> n;
 
    adj.assign(n + 1, list<int>());
 
    for (; i < n; ++i) {
        cin >> u >> v;
        adj[u].pb(v);
        adj[v].pb(u);
    }
 
    return cout << fixed << dfs(), 0;
}
