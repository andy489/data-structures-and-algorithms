// github.com/andy489

// https://codeforces.com/problemset/problem/862/B

#include <iostream>
#include <vector>
#include <list>
 
using namespace std;
 
vector<list<long>> adj;
vector<bool> vis;
 
void dfs(long &odd, int u = 1, int lvl = 0) {
    vis[u] = true;
    if (lvl & 1)
        ++odd;
    for (auto x: adj[u])
        if (!vis[x])
            dfs(odd, x, lvl + 1);
}
 
int main() {
    size_t n, i(1), u, v;
    cin >> n;
 
    adj.assign(n + 1, list<long>());
    vis.assign(n + 1, false);
 
    for (; i < n; ++i) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    long odd(0); //level
    dfs(odd);
 
    return cout<< (n - odd) * odd - n + 1, 0;
}
