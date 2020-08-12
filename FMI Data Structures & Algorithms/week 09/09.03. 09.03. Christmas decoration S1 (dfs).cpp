// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/challenge-2303

#include <stdio.h>
#include <unordered_map>
#include <unordered_set>
#include <list>

using namespace std;

unordered_map<int, list<int>> adj;
unordered_set<int> vis;

void dfs(int u) {
    vis.insert(u);
    for (const int &child: adj[u])
        if (!vis.count(child))
            dfs(child);
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    int u, v;
    while (m--) {
        scanf("%d %d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int cnt(0);
    for (const auto kvp: adj) {
        if (!vis.count(kvp.first)) {
            ++cnt;
            dfs(kvp.first);
        }
    }
    int ans = n - adj.size() + cnt;
    return printf("%d", ans), 0;
}
