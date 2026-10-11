// https://www.hackerrank.com/contests/practice-9-sda/challenges/forest-1

#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

struct Edge {
    int from, to, cost;

    bool operator<(const Edge &other) const {
        return cost < other.cost;
    }
};

int n;
vector<Edge> edges, result;
vector<int> parent, depth;

void initSets() {
    for (int i = 0; i < n; ++i) {
        parent[i] = i;
        depth[i] = 0;
    }
}

void inputEdges() {
    int m;
    scanf("%d %d", &n, &m);

    edges.reserve(n);
    parent.resize(n);
    depth.resize(n);
    result.reserve(n - 1);

    int from, to, cost;
    while (m--) {
        scanf("%d %d %d", &from, &to, &cost);
        edges.push_back({from, to, cost});
    }
}

int findSet(int v) {
    if (parent[v] == v) {
        return v;
    }
    return parent[v] = findSet(parent[v]);
}

void unionSets(int u, int v) {
    int a = findSet(u);
    int b = findSet(v);
    if (a != b) {
        if (depth[a] < depth[b]) {
            swap(a, b);
        }
        parent[b] = a;

        if (depth[a] == depth[b]) {
            depth[a]++;
        }
    }
}

int solve() {
    int mstCost = 0;

    for (const Edge e: edges) {
        if (findSet(e.to) != findSet(e.from)) {
            mstCost += e.cost;
            result.push_back(e);
            unionSets(e.to, e.from);
        }
    }

    return mstCost;
}

int main() {
    inputEdges();
    sort(edges.begin(), edges.end());
    initSets();
    printf("%d", solve());
}
