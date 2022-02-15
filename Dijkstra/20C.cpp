//  http://codeforces.com/contest/20/problem/C

//  Time:   O(|V|+|E|.log(|V|)) =   O((n + m).log(n))
//  Space:  O(|V|+|E|)          =   O(n + m)

#include <cstdio>
#include <vector>
#include <list>
#include <queue>
#include <stack>

using namespace std;

int n;
const long long INF = 0xffffffffff;

vector<list<pair<int, int>>> adj;
vector<bool> visited;
vector<int> parent;
vector<long long> dist;

void init() {
    int m;
    scanf("%d %d", &n, &m);

    adj.resize(n + 1);
    visited.resize(n + 1, false);
    parent.resize(n + 1);
    dist.resize(n + 1, INF);

    for (int i = 1; i <= n; ++i) {
        parent[i] = i;
    }

    int u, v, w;
    while (m--) {
        scanf("%d %d %d", &u, &v, &w);
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }
}

void dijkstra(int start = 1) {
    priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<>> Q;
    Q.push({0, start});
    dist[start] = 0;

    while (!Q.empty()) {
        int u = Q.top().second;
        Q.pop();

        if (u == n) {
            return;
        }

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
                parent[v] = u;
            }
        }
    }
}

void restore_path(int start_node) {
    if (parent[n] == n) { // or id dist[n] == INF
        return void(printf("-1\n"));
    }

    printf("%d ", start_node);
    int traversal_node = n;
    stack<int> path;
    path.push(traversal_node);

    while (parent[traversal_node] != start_node) {
        traversal_node = parent[traversal_node];
        path.push(traversal_node);
    }

    while (!path.empty()) {
        printf("%d ", path.top());
        path.pop();
    }
}

int main() {
    init();
    dijkstra();
    restore_path(1);
    return 0;
}
