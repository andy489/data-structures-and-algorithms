// https://www.hackerrank.com/contests/practice-9-sda/challenges/kruskalmstrsub

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector<int> parent;
vector<pair<int, pair<int, int> >> edge;

void init_sets() {
    edge.resize(m);
    parent.resize(n + 1);

    for (int i = 0; i <= n; ++i) {
        parent[i] = i;
    }
}

int find_set(int x) {
    return parent[x] == x ? x : parent[x] = find_set(parent[x]);
}

int main() {
    cin >> n >> m;

    init_sets();

    int u, v, w;
    for (int i = 0; i < m; ++i) {
        cin >> u >> v >> w;
        edge[i] = make_pair(w, make_pair(u, v));
    }

    sort(edge.begin(), edge.end());

    int mst_cost = 0;

    for (int i = 0; i < m; ++i) {
        int x = find_set(edge[i].second.first);
        int y = find_set(edge[i].second.second);

        if (x != y) {
            parent[x] = y;
            mst_cost += edge[i].first;
        }
    }

    cout << mst_cost;

    return 0;
}
