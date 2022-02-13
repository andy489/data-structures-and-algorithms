// https://www.hackerrank.com/contests/practice-9-sda/challenges/forest-1

#include <cstdio>
#include <vector>
#include <set>

using namespace std;

static const int INF = 1 << 10;

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
vector<Edge> mst;

int prim(int start) {
    int totalCost = 0;

    mst[start].cost = 0;

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
            if (!visited[e.to] && e.cost < mst[e.to].cost) {
                s.erase({e.to, mst[e.to].cost});
                mst[e.to] = {curr.to, e.cost};
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
    mst.resize(n);

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

void printMST() {
    for (int i = 0; i < n; ++i) {
        Edge curr = mst[i];

        if (curr.to != -1) {
            printf("\n<%d, %d>, <%d>", i, curr.to, curr.cost);
        }
    }
}

int main() {
    init();
    printf("%d", solve());
    // printMST();

    return 0;
}

/*
9 11
0 3 2
4 5 2
3 7 5
1 3 5
5 2 4
5 8 2
1 7 2
0 7 4
4 8 3
0 1 3
2 8 3
*/
