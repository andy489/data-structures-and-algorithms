// https://www.hackerrank.com/contests/daa-2020-2021-winter-test2/challenges/hierarchy-1/problem

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Edge {
    int from;
    int to;
    int cost;

    Edge(int from, int to, int cost) : from(from), to(to), cost(cost) {}

    bool operator<(const Edge &other) const {
        return cost < other.cost;
    }
};

int n;

vector<int> q;
vector<Edge> edges;

vector<int> parent;
vector<int> depth;

vector<bool> has_boss;

void unite_sets(int from, int to) {
    if (depth[from] > depth[to]) {
        parent[to] = from;
    } else {
        parent[from] = to;
    }

    if (depth[from] == depth[to]) {
        ++depth[to];
    }
}

int find_set(int x) {
    return parent[x] == x ? x : parent[x] = find_set(parent[x]);
}

void init_sets() {
    parent.resize(n);
    depth.resize(n, 0);

    for (int i = 0; i < n; ++i) {
        parent[i] = i;
    }
}

int main() {
    cin >> n;
    q.resize(n);

    for (int i = 0; i < n; ++i) {
        cin >> q[i];
    }

    int m;
    cin >> m;

    edges.reserve(m);

    int a, b, c;
    while (m--) {
        cin >> a >> b >> c;
        --a, --b;
        edges.emplace_back(a, b, c);
    }

    sort(edges.begin(), edges.end());

    init_sets();

    int answer = 0;
    int br = 0;

    has_boss.resize(n, false);

    for (const auto &e: edges) {
        int from = e.from;
        int to = e.to;
        int cost = e.cost;

        if (q[from] > q[to] && !has_boss[to]) {
            if (find_set(from) != find_set(to)) {
                has_boss[to] = true;

                unite_sets(from, to);

                answer += cost;
                ++br;
            }
        }
    }

    cout << (br == n - 1 ? answer : -1) << endl;

    return 0;
}
