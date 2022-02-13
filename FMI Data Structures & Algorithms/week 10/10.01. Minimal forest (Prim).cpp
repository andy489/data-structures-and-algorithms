// https://www.hackerrank.com/contests/practice-9-sda/challenges/forest-1

#include <cstdio>
#include <vector>
#include <set>

using namespace std;

static const int INF = 1 << 18;

struct Edge {
    int to = -1;
    int cost = INF;

    Edge() = default;

    Edge(int to, int cost) : to(to), cost(cost) {}

    bool operator<(const Edge &rhs) const {
        return make_pair(cost, to) < make_pair(rhs.cost, rhs.to);
    }
};

int n, m; // nodes and edges
int from, to, w;

vector<vector<Edge>> adj;
vector<bool> visited;

int prim(int start) {
    int total_weight = 0;

    vector<Edge> min_edge(n);
    min_edge[start].cost = 0;

    set<Edge> s;
    s.insert({start, 0});

    for (int i = 0; i < n; i++) {
        if (s.empty()) {
            break;
        }

        int u = s.begin()->to;
        visited[u] = true;

        total_weight += s.begin()->cost;
        s.erase(s.begin());

        for (const Edge e : adj[u]) {
            if (!visited[e.to] && e.cost < min_edge[e.to].cost) {
                s.erase({e.to, min_edge[e.to].cost});
                min_edge[e.to] = {u, e.cost};
                s.insert({e.to, e.cost});
            }
        }
    }

    return total_weight;
}

void init() {
    scanf("%d %d", &n, &m);

    adj.resize(n);
    visited.resize(n);

    for (int i = 0; i < m; ++i) {
        scanf("%d %d %d", &from, &to, &w);

        adj[from].push_back({to, w});
        adj[to].push_back({from, w});
    }
}

int solve() {
    int minimalForestCost = 0;

    for (int i = 0; i < n; ++i) {
        if (!visited[i]) {
            minimalForestCost += prim(i);
        }
    }

    return minimalForestCost;
}

int main() {
    return init(), printf("%d", solve()), 0;
}
