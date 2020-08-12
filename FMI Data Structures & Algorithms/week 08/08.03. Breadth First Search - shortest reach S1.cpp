// github.com/andy489

// https://www.hackerrank.com/challenges/bfsshortreach/problem

// github.com/andy489

// https://www.hackerrank.com/challenges/bfsshortreach/problem

#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

struct Node {
    int dist, visited;
    vector<int> adj;

    Node(int dist = INT_MAX, int visited = 0)
            : dist(dist), visited(visited) {}
};

void bfs(vector<Node> &graph, int s) {
    queue<int> q;
    q.push(s);
    int curr, dist(0), i, child;
    graph[s].visited = 1;
    graph[s].dist = 0;

    while (!q.empty()) {
        curr = q.front();
        q.pop();

        dist = graph[curr].dist + 6;

        for (i = 0; i < graph[curr].adj.size(); ++i) {
            child = graph[curr].adj[i];
            if (!graph[child].visited) {
                q.push(child);
                graph[child].visited = 1;
                graph[child].dist = dist;
            }
        }
    }
}

int main() {
    int q, n, m, a, b, start, i;
    cin >> q;
    while (q--) {
        cin >> n >> m;

        vector<Node> graph(n + 1);

        for (i = 0; i < m; ++i) {
            cin >> a >> b;
            graph[a].adj.push_back(b);
            graph[b].adj.push_back(a);
        }
        cin >> start;

        bfs(graph, start);

        for (i = 1; i <= n; ++i) {
            if (graph[i].dist == INT_MAX)
                cout << "-1 ";
            else if (i != start)
                cout << graph[i].dist << " ";
            else
                continue;
        }
        cout << "\n";
    }
    return 0;
}
