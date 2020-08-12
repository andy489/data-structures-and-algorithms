// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/challenge-2303

#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <list>
#include <queue>

using namespace std;

typedef unordered_map<int, list<int>> Graph;
typedef unordered_set<int> Table;

void inp(int m, Graph &g, Table &visited) {
    int u, v;
    while (m--) {
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }
}

void bfs(const Graph &g, Table &visited, int start) {
    queue<int> q;
    q.push(start);
    visited.insert(start);
    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        for (const int &child: g.find(curr)->second)
            if (!visited.count(child)) {
                visited.insert(child);
                q.push(child);
            }
    }
}

int solve(int n, const Graph &g, Table &visited) {
    int components = 0;
    for (const auto &p: g)
        if (!visited.count(p.first)) {
            bfs(g, visited, p.first);
            ++components;
        }
    return n - g.size() + components;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    Graph g;
    Table visited;

    inp(m, g, visited);
    cout << solve(n, g, visited) << endl;
}
