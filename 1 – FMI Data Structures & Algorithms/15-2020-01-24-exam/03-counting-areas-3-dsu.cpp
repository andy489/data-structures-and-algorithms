// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2351

#include <iostream>
#include <vector>

using namespace std;

vector<int> parent;
vector<int> sz;

int comp;

void init_sets(int n) {
    comp = n;

    parent.resize(n);
    sz.resize(n);

    for (int i = 0; i < n; ++i) {
        sz[i] = 0;
        parent[i] = i;
    }
}

int find_set(int x) {
    return parent[x] = parent[x] == x ? x : find_set(parent[x]);
}

void union_sets(int a, int b) {
    int r1 = find_set(a);
    int r2 = find_set(b);

    if (r1 != r2) {
        --comp;
        if (sz[r1] < sz[r2]) {
            swap(r1, r2);
        }

        parent[r1] = r2;
        sz[r2] += sz[r1];
    }
}

int main() {
    int q;
    cin >> q;

    while (q--) {
        int n, m;
        cin >> n >> m;

        init_sets(n);

        int u, v;
        while (m--) {
            cin >> u >> v;
            union_sets(u, v);
        }
        
        cout<< comp << ' ';
    }

    return 0;
}