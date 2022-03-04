#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Graph {
    vector<vector<int>> adj;
    int V, E;

    void dfs_util(int u, vector<bool> &visited) {
        cout << u << ' ';
        visited[u] = true;

        const int NEIGHBOURS_SZ = adj[u].size();
        for (int i = 0; i < NEIGHBOURS_SZ; ++i) {
            if (!visited[adj[u][i]]) {
                dfs_util(adj[u][i], visited);
            }
        }
    }

    void bfs_util(int start, vector<bool> &visited) {
        queue<int> q;
        q.push(start);

        int level = 1;
        while (!q.empty()) {
            int Q_SIZE = q.size();

            while (Q_SIZE--) {
                int curr = q.front();
                q.pop();

                visited[curr] = true;

                cout << curr << ' ';

                const int NEIGHBOURS_SZ = adj[curr].size();
                for (int i = 0; i < NEIGHBOURS_SZ; ++i) {
                    if (!visited[adj[curr][i]]) {
                        q.push(adj[curr][i]);
                        visited[adj[curr][i]] = true;
                    }
                }
            }

            ++level;
        }
    }

public:
    explicit Graph(int n) : V(n), E(0) {
        adj.resize(n + 1);
    }

    void add_edge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u);

        ++E;
    }

    void dfs(int start) {
        vector<bool> visited(V + 1);

        dfs_util(start, visited);
    }

    void bfs(int start) {
        vector<bool> visited(V + 1);

        bfs_util(start, visited);
    }
};

int main() {
    int n, m;
    cout << "Enter number of vertices and number of edges of the graph: ";
    cin >> n >> m;

    Graph G(n);

    int u, v;
    cout << "Enter edges represented as two vertices: ";
    while (m--) {
        cin >> u >> v;
        G.add_edge(u, v);
    }

    cout << "Depth First Search:"
         << endl;

    G.dfs(1);

    cout << endl
         << "Breadth First Search:"
         << endl;

    G.bfs(1);

    return 0;
}

/*
8 7
1 2
3 6
2 3
1 4
5 3
4 3
7 8
*/
