// https://www.hackerrank.com/contests/practice-9-sda/challenges/forest-1

#include <cstdio>
#include <vector>
#include <set>

using namespace std;

static const int INF = 2 << 10;

struct Edge {
    int to = -1;
    int cost = INF;

    bool operator<(const Edge &other) const {
        if (cost == other.cost) {
            return to < other.to;
        }

        return cost < other.cost;
    }
};

int n;

vector<vector<Edge>> adj;
vector<bool> visited;

int prim(int start) {
    int totalCost = 0;

    vector<Edge> minEdge(n);
    minEdge[start].cost = 0;

    set<Edge> s;
    s.insert({start, 0});

    for (int i = 0; i < n; i++) {
        if (s.empty()) {
            break;
        }

        Edge curr = *s.begin();
        s.erase(curr);

        visited[curr.to] = true;
        totalCost += curr.cost;


        for (const Edge e : adj[curr.to]) {
            if (!visited[e.to] && e.cost < minEdge[e.to].cost) {
                s.erase({e.to, minEdge[e.to].cost});
                minEdge[e.to] = {curr.to, e.cost};
                s.insert({e.to, e.cost});
            }
        }
    }

    return totalCost;
}

void init() {
    int m;
    scanf("%d %d", &n, &m);

    adj.resize(n);
    visited.resize(n);

    int from, to, cost;
    while (m--) {
        scanf("%d %d %d", &from, &to, &cost);

        adj[from].push_back({to, cost});
        adj[to].push_back({from, cost});
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
