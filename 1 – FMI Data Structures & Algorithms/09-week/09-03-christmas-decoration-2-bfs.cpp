// https://www.hackerrank.com/contests/practice-8-sda/challenges/christmas-decoration

#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <list>
#include <queue>

using namespace std;

int n;
unordered_map<int, list<int>> adj;
unordered_set<int> vis;

void input() {
    int m;
    cin >> n >> m;

    int u, v;
    while (m--) {
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }
}

void bfs(int start) {
    queue<int> q;
    q.push(start);
    vis.insert(start);

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (int child: adj.find(curr)->second) {
            if (!vis.count(child)) {
                vis.insert(child);
                q.push(child);
            }
        }
    }
}

int solve() {
    int components = 0;

    for (const auto &kvp: adj) {
        if (!vis.count(kvp.first)) {
            bfs(kvp.first);
            ++components;
        }
    }

    return n - (int) adj.size() + components;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    input();

    cout << solve() << endl;
}