// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/-1-12/problem

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<list<int>> adj;
vector<bool> visited;

vector<int> top_sort;
vector<int> indexes;

void dfs(int s) {
    visited[s] = true;
    for (const auto &child:adj[s]) {
        if (!visited[child]) {
            dfs(child);
        }
    }

    top_sort.push_back(s);
    indexes[s] = top_sort.size() - 1;
}

int main() {
    int q;
    cin >> q;

    int n, m;
    while (q--) {
        cin >> n >> m;

        adj.assign(n, list<int>());
        visited.assign(n, false);

        top_sort.clear();
        indexes.assign(n, 0);

        int a, b, w;
        while (m--) {
            cin >> a >> b >> w; // not using w
            adj[a - 1].push_back(b - 1);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        int back_edges = 0;

        // O(n * n) for dense graphs
        for (int i = 0; i < n; ++i) {
            for (int child:adj[i]) {
                if (indexes[i] < indexes[child]) {
                    ++back_edges;
                }
            }
        }

        back_edges ? cout << "true " : cout << "false ";
    }

    return 0;
}
