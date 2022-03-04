// https://www.hackerrank.com/contests/practice-9-sda/challenges/roads-5

#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> parent, sz;

void init_sets() {
    parent.resize(n + 1);
    sz.resize(n + 1);

    for (int i = 0; i < n; ++i) {
        parent[i] = i;
        sz[i] = 1;
    }
}

int find_set(int v) {
    return parent[v] == v ? v : parent[v] = find_set(parent[v]);
}

void unite_sets(int a, int b) {
    int r1 = find_set(a);
    int r2 = find_set(b);

    if (r1 == r2) {
        return;
    } else {
        if (sz[r1] < sz[r2]) {
            swap(r1, r2);
        }

        parent[r1] = r2;
        sz[r2] += sz[r1];
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> n >> m;

    init_sets();

    int u, v;
    while (m--) {
        cin >> u >> v;
        unite_sets(u, v);
    }

    int q, c;
    cin >> q;
    for (int i = 0; i < q; ++i) {
        cin >> c >> u >> v;
        if (c == 1) {
            cout << (find_set(u) == find_set(v));
        } else {
            unite_sets(u, v);
        }
    }
}
