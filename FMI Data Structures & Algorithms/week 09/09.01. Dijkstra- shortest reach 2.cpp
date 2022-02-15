// https://www.hackerrank.com/challenges/dijkstrashortreach/problem

#include <cstdio>
#include <vector>
#include <list>
#include <queue>

using namespace std;

const int INF = 0x7fffffff;

int n;

vector<list<pair<int, int>>> adj;
vector<bool> visited;
vector<int> dist;

void dijkstra(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> Q;
    Q.push({0, start});
    dist[start] = 0;

    while (!Q.empty()) {
        int u = Q.top().second;

        Q.pop();
        if (visited[u]) {
            continue;
        }

        visited[u] = true;

        for (const auto &child : adj[u]) {
            if (visited[child.first]) {
                continue;
            }

            int v = child.first;
            int w = child.second;

            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                Q.push({dist[v], v});
            }
        }
    }
}

void display_distances(int start){
    for (int i = 1; i <= n; ++i) {
        if (i != start) {
            if (dist[i] == INF) {
                printf("%d ", -1);
            } else {
                printf("%d ", dist[i]);
            }
        }
    }
}

int main() {
    int t;
    scanf("%d", &t);

    while (t--) {
        int m;
        scanf("%d %d", &n, &m);

        int u, v, w;

        adj.assign(n + 1, list<pair<int, int>>());
        visited.assign(n + 1, false);
        dist.assign(n + 1, INF);

        while (m--) {
            scanf("%d %d %d", &u, &v, &w);
            adj[u].push_back({v, w});
            adj[v].push_back({u, w});
        }

        int start;
        scanf("%d", &start);

        dijkstra(start);
        display_distances(start);

        printf("\n");
    }
    return 0;
}
