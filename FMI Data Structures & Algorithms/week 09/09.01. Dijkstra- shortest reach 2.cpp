// github.com/andy489

// https://www.hackerrank.com/challenges/dijkstrashortreach/problem

#include <cstdio>
#include <vector>
#include <queue>
#include <climits>

using namespace std;
typedef pair<int, int> pii;

class Graph {
    vector<vector<pii>> adj;
    vector<bool> visited;
    vector<int> paths;

    int v;

    void clearVisited() {
        visited.assign(v + 1, 0);
    }

public:
    Graph(int v) : v(v) {
        adj.assign(v + 1, vector<pii>());
        paths.assign(v + 1, INT_MAX);
    }

    void insert(pii v1, pii v2) {
        adj[v1.second].push_back(v2);
        adj[v2.second].push_back(v1);
    }

    void djiikstra(int start) {
        clearVisited();
        priority_queue<pii, vector<pii>, greater<pii>> pq;
        pq.push({0, start});
        paths[start] = 0;

        while (!pq.empty()) {
            int dist = pq.top().first;
            int v = pq.top().second;
            pq.pop();
            if (visited[v])
                continue;
            visited[v] = true;
            for (const auto &child : adj[v]) {
                if (visited[child.second])
                    continue;
                if (paths[v] + child.first < paths[child.second]) {
                    paths[child.second] = paths[v] + child.first;
                    pq.push({paths[child.second], child.second});
                }
            }
        }

        for (int i = 1; i <= v; ++i) {
            if (i != start) {
                if (paths[i] == INT_MAX)
                    printf("%d ", -1);
                else
                    printf("%d ", paths[i]);
            }
        }
    }
};


int main() {
    int t;
    scanf("%d", &t);

    while (t--) {
        int n, m;
        scanf("%d %d", &n, &m);

        int v1, v2, weight;

        Graph G(n);

        while (m--) {
            scanf("%d %d %d", &v1, &v2, &weight);
            G.insert({weight, v1}, {weight, v2});
        }

        int start;
        scanf("%d", &start);

        G.djiikstra(start);
        printf("\n");
    }
    return 0;
}
