// github.com/andy489

// https://codeforces.com/problemset/problem/1325/E

#include <iostream>
#include <vector>
#include <list>
#include <queue>
#include <tuple>

using namespace std;

#define ios ios::sync_with_stdio(false); cin.tie(nullptr)

vector<list<int>> adj;
int maxEdge = -1;

int bfs(int u, int par = -1) { // u = start node, par = parent
    vector<int> dist(maxEdge + 1, 1e9); // dist = distances to start node
    dist[u] = 0;
    queue<pair<int, int>> q;
    q.push({u, par});
    while (!q.empty()) {
        int v, fa; // v = vertex/node, fa = father/parent
        tie(v, fa) = q.front();
        q.pop();
        for (const auto &child:adj[v]) {
            if (child == fa) continue;
            if (dist[child] == 1e9) {
                q.push({child, v});
                dist[child] = dist[v] + 1;
            } else { // we have already visited that node, so there is a cycle
                return dist[child] + dist[v] + 1;
            }
        }
    }
    return 1e9;
}

void normalize(int &x) {
    for (int i = 2; i * i <= x; ++i) {
        while (x % (i * i) == 0) {
            x /= (i * i);
        }
    }
}

int main() {
    ios;
    int n; cin >> n;
    vector<int> e(n); // edges (in the analysis we said that every element is like an edge)
    for (int &edge: e) {
        cin >> edge;
        normalize(edge); // normalizing every edge
        if (edge == 1)
            return cout << 1, 0;
        if (edge > maxEdge)
            maxEdge = edge; // finding max Ai after normalization
    }

    adj.assign(maxEdge + 1, list<int>()); // adjacency list

    for (auto &x: e) {
        int fac1 = 1, fac2 = x;
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                fac1 = i;
                fac2 = x / i;
                break;
            }
        }
        adj[fac1].push_back(fac2);
        adj[fac2].push_back(fac1);
    }

    int ans = 1e9;

    for (int i = 1; i * i <= maxEdge; ++i) {
        if (adj[i].size()) { // we know that every vertex is a prime number or 1
            ans = min(ans, bfs(i));
        }
    }

    return cout << (ans == 1e9 ? -1 : ans), 0;
}
