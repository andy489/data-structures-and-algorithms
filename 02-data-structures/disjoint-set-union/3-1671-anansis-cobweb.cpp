// https://acm.timus.ru/problem.aspx?space=1&num=1671

#include <iostream>

using namespace std;

const int mxN = 1e5 + 5;

int parent[mxN];
int r[mxN];

pair<int, int> edges[mxN];

int edge_number[mxN];
bool deleted_edge[mxN];


int find_set(int x) {
    return parent[x] == x ? x : parent[x] = find_set(parent[x]);
}

int unite_sets(pair<int, int> e) {
    int a = find_set(e.first);
    int b = find_set(e.second);

    if (a == b)
        return 0;
    if (r[a] > r[b]) {
        parent[b] = a;
    } else {
        parent[a] = b;

        if (r[a] == r[b]) {
            ++r[b];
        }
    }

    return 1;
}

int main() {
    int n, m;
    cin >> n >> m;

    int u, v;
    for (int i = 1; i <= m; ++i) {
        cin >> u >> v;
        edges[i] = {u, v};
    }

    int q;
    cin >> q;

    for (int i = 1; i <= q; ++i) {
        cin >> edge_number[i];
        deleted_edge[edge_number[i]] = true;
    }

    for (int i = 1; i <= n; ++i) {
        parent[i] = i;
    }

    int components_cnt = n;
    for (int i = 1; i <= m; ++i) {
        if (!deleted_edge[i]) {
            components_cnt -= unite_sets(edges[i]);
        }
    }

    edge_number[q + 1] = components_cnt;

    for (int i = q; i > 1; --i) {
        components_cnt -= unite_sets(edges[edge_number[i]]);
        edge_number[i] = components_cnt;
    }

    for (int i = 2; i <= q + 1; ++i) {
        cout << edge_number[i] << ' ';
    }

    return 0;
}
