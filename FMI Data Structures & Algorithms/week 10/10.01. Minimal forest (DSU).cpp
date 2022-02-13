// https://www.hackerrank.com/contests/practice-9-sda/challenges/forest-1

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Edge {
    int from, to, w;

    bool operator<(const Edge &other) {
        return w < other.w;
    }
};

vector<Edge> edges;
int p[20000], depth[20000], n, m;

void init() {
    int i(0);
    for (; i < n; ++i)
        p[i] = i, depth[i] = 1;
}

int find(int v) {
    if (p[v] == v)
        return v;
    return p[v] = find(p[v]);
}

int uni(Edge x) {
    int r1 = find(x.from), r2 = find(x.to);
    if (r1 == r2)
        return 0;
    else {
        if (depth[r1] < depth[r2])
            swap(r1, r2);
        p[r2] = r1;
        if (depth[r1] == depth[r2])
            depth[r1]++;
        return x.w;
    }
}

int main() {
    int ans(0);
    cin >> n >> m;
    int from, to, w, i(0);
    for (; i < m; ++i) {
        cin >> from >> to >> w;
        edges.push_back({from, to, w});
    }
    
    init();

    sort(edges.begin(), edges.end());

    for (i = 0; i < m; ++i)
        ans += uni(edges[i]);
    return cout << ans, 0;
}
