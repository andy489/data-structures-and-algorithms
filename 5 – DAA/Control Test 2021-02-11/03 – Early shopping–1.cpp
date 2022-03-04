// https://www.hackerrank.com/contests/daa-2020-2021-winter-test1/challenges/challenge-2870

#include<iostream>
#include<vector>
#include<unordered_map>
#include<unordered_set>

using namespace std;

#define pb push_back
#define f first

unordered_set<int> vis;
unordered_map<int, vector<int>> adj;

int N, M;

void dfs(int u) {
    vis.insert(u);

    for (int child : adj[u]) {
        if (!vis.count(child)) {
            dfs(child);
        }
    }
}

void init() {
    cin >> N >> M;

    int u, v;
    while (M--) {
        cin >> u >> v;

        adj[u].pb(v);
        adj[v].pb(u);
    }
}

void cnt_comp(int &comp) {
    for (const auto &v : adj) {
        if (!vis.count(v.f)) {
            ++comp;
            dfs(v.f);
        }
    }
}

int main() {
    int comp;

    init();

    cnt_comp(comp);

    printf("%d", N - (int) vis.size() + comp);

    return 0;
}
